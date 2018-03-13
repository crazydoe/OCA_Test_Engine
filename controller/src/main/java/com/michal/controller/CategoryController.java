package com.michal.controller;

import com.michal.dto.manager.CategoryDTO;
import com.michal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "api/categories/")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") long id) {
        Optional<CategoryDTO> foundCategory = categoryService.getOne(id);

        return foundCategory.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping()
    public ResponseEntity<Set<CategoryDTO>> getAll() {
        Set<CategoryDTO> categories = categoryService.getAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<CategoryDTO> newCategory(@RequestParam(value = "name") String name,
                                                   @RequestParam(value = "description") String description) {
        CategoryDTO category = categoryService.createCategory(name, description);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        if(categoryService.delete(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
