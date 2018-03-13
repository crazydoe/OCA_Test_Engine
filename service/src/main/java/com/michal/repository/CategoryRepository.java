package com.michal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.michal.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
