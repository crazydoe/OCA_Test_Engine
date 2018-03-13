package com.michal.service.implement;

import com.michal.dto.manager.CategoryDTO;
import com.michal.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.michal.model.entity.Category;
import com.michal.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Component
public class CategoryServiceBean implements CategoryService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CategoryServiceBean(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Optional<CategoryDTO> getOne(final Long id) {
        Optional<Category> foundCategory = Optional.ofNullable(categoryRepository.findOne(id));
        return foundCategory.map(category -> modelMapper.map(category, CategoryDTO.class));
    }

    @Override
    public Set<CategoryDTO> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<CategoryDTO> checkIfExists(final String name) {
        Optional<Category> foundCategory = Optional.ofNullable(categoryRepository.findByName(name));
        return foundCategory.map(category -> modelMapper.map(category, CategoryDTO.class));
    }

    @Override
    public CategoryDTO createCategory(final String name, final String description) {
        Optional<Category> foundCategory = Optional.ofNullable(categoryRepository.findByName(name));
        return foundCategory.map(category -> modelMapper.map(category, CategoryDTO.class))
                .orElseGet(() -> {
                    Category newCategory = categoryRepository.save(
                            new Category().setName(name).setDescription(description));
                    return modelMapper.map(newCategory, CategoryDTO.class);
                });
    }

    @Override
    public boolean delete(final Long id) {
        Category entity = categoryRepository.findOne(id);
        if (entity == null) {
            log.error("DELETE: category not found, categoryId: " + id);
            return false;
        } else {
            categoryRepository.delete(entity);
            return true;
        }
    }
}
