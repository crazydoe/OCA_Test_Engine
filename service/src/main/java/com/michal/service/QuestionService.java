package com.michal.service;

import com.michal.dto.common.QuestionDTO;
import com.michal.dto.common.QuestionSetDTO;
import com.michal.dto.consumer.QuestionSendToUserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuestionService {

    Optional<QuestionSetDTO> getRandom(Long categoryId, Long tagId, Long quantity);

    Optional<QuestionSendToUserDTO> getOne(Long id);

    List<QuestionDTO> getAll();

    @Transactional
    Optional<QuestionDTO> save(QuestionDTO newQuestion);

    Optional<QuestionDTO> update(QuestionDTO question);

    Boolean delete(Long id);

    Set<QuestionDTO> getAllWaiting();
}
