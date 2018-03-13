package com.michal.dto.manager;

import java.util.HashSet;
import java.util.Set;

public class CategoryDTO {

    private Long id;
    private String name;
    private String description;
    private Set<CategoryDTO> questions = new HashSet<>();

    public Long getId() { return id; }

    public CategoryDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() { return name; }

    public CategoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() { return description; }

    public CategoryDTO setDescription(String description) {
        this.description = description;
        return this;
    }

}
