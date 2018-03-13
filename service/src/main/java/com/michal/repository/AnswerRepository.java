package com.michal.repository;

import com.michal.model.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AnswerRepository extends JpaRepository<Answer, Long>{

    Set<Answer> getByQuestionIdAndCorrect(Long questionId, boolean correct);
}
