package com.michal.service;

import com.michal.dto.manager.CategoryDTO;

import java.util.Optional;
import java.util.Set;

public interface CategoryService {

    Optional<CategoryDTO> getOne(Long id);

    Set<CategoryDTO> getAll();

    Optional<CategoryDTO> checkIfExists(String name);

    CategoryDTO createCategory(String name, String description);

    boolean delete(Long id);
}
