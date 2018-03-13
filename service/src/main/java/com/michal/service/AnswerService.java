package com.michal.service;

import com.michal.dto.consumer.AnswerSetDTO;

import java.util.Optional;

public interface AnswerService {
    Optional<AnswerSetDTO> verifyAnswers(AnswerSetDTO answerSet);
}
