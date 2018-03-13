package com.michal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    private String description;

    public Long getId() { return id; }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() { return name; }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() { return description; }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
