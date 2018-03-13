package com.michal.service.implement;

import com.michal.converter.implement.QuestionConverter;
import com.michal.dto.common.QuestionSetDTO;
import com.michal.dto.consumer.QuestionSendToUserDTO;
import com.michal.model.entity.*;
import com.michal.repository.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.michal.dto.common.QuestionDTO;
import com.michal.repository.*;
import com.michal.service.QuestionService;
import com.michal.model.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Component
public class QuestionServiceBean implements QuestionService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private QuestionRepository questionRepository;
    private CategoryRepository categoryRepository;
    private QuestionSetRepository questionSetRepository;
    private AnswerRepository answerRepository;
    private TagRepository tagRepository;
    private QuestionConverter converter;
    private ModelMapper mapper;

    public QuestionServiceBean(final QuestionRepository questionRepository, final CategoryRepository categoryRepository,
                               final TagRepository tagRepository, final QuestionSetRepository questionSetRepository,
                               final QuestionConverter converter, final AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
        this.questionSetRepository = questionSetRepository;
        this.answerRepository = answerRepository;
        this.tagRepository = tagRepository;
        this.converter = converter;
        this.mapper = new ModelMapper();
    }

    @Override
    public Optional<QuestionSetDTO> getRandom(final Long categoryId, final  Long tagId, final Long quantity) {
        Optional<Tag> tagEntity = Optional.ofNullable(tagRepository.findOne(tagId));
        Optional<Category> categoryEntity = Optional.ofNullable(categoryRepository.findOne(categoryId));

        if (!tagEntity.isPresent()) {
            // TODO rzuć wyjątek - brak tagu
            return Optional.empty();
        }
        if (!categoryEntity.isPresent()) {
            // TODO rzuć wyjątek - brak kategorii
            return Optional.empty();
        }

        List<Question> questions = questionRepository
                .findAllByCategoriesAndTagsAndVisible(categoryEntity.get(), tagEntity.get(), true);

        if (questions.size() < quantity) {
            return Optional.empty();
            // TODO rzucić wyjątek informujący o przekroczeniu liczby dostępnych pytań
        }

        List<Question> randomQuestions = getRandomList(questions, quantity.intValue());

        QuestionSet questionSet = new QuestionSet();
        questionSet.setQuestions(randomQuestions);
        questionSet.addCategory(categoryEntity.get());
        questionSet.addTag(tagEntity.get());
        questionSet.setRandom(true);

        questionSetRepository.save(questionSet);

        return Optional.ofNullable(mapper.map(questionSet, QuestionSetDTO.class));

    }

    @Cacheable("question")
    @Override
    public Optional<QuestionSendToUserDTO> getOne(final Long id) {
        return Optional.ofNullable(questionRepository.findOne(id)).map(converter::toDTO);
    }

    @Override
    public List<QuestionDTO> getAll() {
        List<Question> questions = questionRepository.findAll();
        return mapper.map(questions, new TypeToken<List<QuestionDTO>>() {
        }.getType());
    }

    @Override
    @Transactional
    public Optional<QuestionDTO> save(final QuestionDTO newQuestion) {
        Question entity = mapper.map(newQuestion, Question.class);
        newQuestion.getCategoriesId().forEach(categoryId -> {
            Category category = categoryRepository.findOne(categoryId);
            if (category != null) {
                entity.addCategory(categoryRepository.findOne(categoryId));
            }
        });
        newQuestion.getTagsId().forEach(tagId -> {
            Tag tag = tagRepository.findOne(tagId);
            if (tag != null) {
                entity.addTag(tag);
            }
        });

        // TODO słabe rozwiązanie, do poprawki (ale działa). Powyższe raczej musi zostać...
        Set<Answer> answers = entity.getAnswers();
        entity.setAnswers(null);
        questionRepository.save(entity);
        answers.forEach(answer -> answer.setQuestion(entity));
        answerRepository.save(answers);
        entity.setAnswers(answers);
        questionRepository.save(entity);

        return Optional.ofNullable((mapper.map(entity, QuestionDTO.class)));
    }

    @Override
    public Optional<QuestionDTO> update(final QuestionDTO question) {
        if (question.getId() == null || !questionRepository.exists(question.getId())) {
            log.error("UPDATE: invalid object");
            // TODO wyrzuć  wyjątek
            return Optional.empty();
        }
        return save(question);
    }


    @Override
    public Boolean delete(final Long id) {
        Question entity = questionRepository.findOne(id);
        if (entity == null) {
            log.error("DELETE: question not found, questionId: " + id);
            return false;
        }
        questionRepository.delete(entity);
        return true;
    }

    @Override
    public Set<QuestionDTO> getAllWaiting() {
        return mapper.map(questionRepository.findAllByVisible(false), new TypeToken<Set<QuestionDTO>>() {
        }.getType());
    }

    private List<Question> getRandomList(final List<Question> list, final int quantity) {
        List<Question> randomPicked = new ArrayList();
        boolean[] used = new boolean[list.size()];

        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }

        int insertedCounter = 0;

        while (insertedCounter < quantity) {
            int rand = ThreadLocalRandom.current().nextInt(0, list.size());
            if (!used[rand]) {
                used[rand] = true;
                randomPicked.add(list.get(rand));
                insertedCounter++;
            }
        }
        return randomPicked;
    }
}