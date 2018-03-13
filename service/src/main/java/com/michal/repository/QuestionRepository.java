package com.michal.repository;

import com.michal.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.michal.model.entity.Category;
import com.michal.model.entity.Question;

import java.util.List;
import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByCategoriesAndTagsAndVisible(Category category, Tag tag, boolean visible);

    Set<Question> findAllByVisible(boolean visible);
}
