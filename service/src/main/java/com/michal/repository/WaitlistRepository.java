package com.michal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.michal.model.entity.QuestionWaitlist;

public interface WaitlistRepository extends JpaRepository<QuestionWaitlist, Long> {

}
