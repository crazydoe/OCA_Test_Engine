package com.michal.service.implement;

import com.michal.model.entity.Answer;
import com.michal.repository.QuestionSetRepository;
import com.michal.service.AnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.michal.dto.consumer.AnswerSetDTO;
import com.michal.model.entity.QuestionSet;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Component
public class AnswerServiceBean implements AnswerService {

    private QuestionSetRepository questionSetRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AnswerServiceBean(final QuestionSetRepository questionSetRepository) {
        this.questionSetRepository = questionSetRepository;
    }

    @Override
    public Optional<AnswerSetDTO> verifyAnswers(final AnswerSetDTO answerSet) {

        QuestionSet setEntity = questionSetRepository.findOne(answerSet.getQuestionSetId());

        if(setEntity == null) {
            log.error("Question set not found, setId: " + answerSet.getQuestionSetId());
            return Optional.empty();
        }

        answerSet.getAnswers().forEach(answer ->
                setEntity.getQuestions().forEach(question -> {
                    if (question.getId().equals(answer.getQuestionId())) {
                        answer.setCorrectId(question.getAnswers().stream()
                                .filter(Answer::getCorrect)
                                .map(Answer::getId)
                                .collect(Collectors.toSet()));

                        if (answer.getSelectedId().size() == answer.getCorrectId().size()) {
                            if (answer.getSelectedId().containsAll(answer.getCorrectId())) {
                                answer.setPassed(true);
                                answerSet.incrementScore();
                            }
                        }
                    }
                }));

        if(setEntity.isRandom()) {
            questionSetRepository.delete(setEntity);
        }
        return Optional.of(answerSet);
    }
}
