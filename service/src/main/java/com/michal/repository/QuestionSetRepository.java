package com.michal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.michal.model.entity.QuestionSet;

@Repository
public interface QuestionSetRepository extends JpaRepository<QuestionSet, Long> {
}
