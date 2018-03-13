package com.michal.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.michal.dto.manager.CategoryDTO;
import com.michal.model.enums.BodyType;
import com.michal.dto.manager.AnswerDTO;
import com.michal.model.enums.AnswerType;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class QuestionDTO {

    private Long id;
    private String title;
    private String body;
    private String footer;
    private Boolean certainty = false;
    private Boolean visible = false;
    private BodyType bodyType;
    private AnswerType answerType;
    private Set<CategoryDTO> categories = new HashSet<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Long> categoriesId = new HashSet<>();
    private Set<TagDTO> tags = new HashSet<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Long> tagsId = new HashSet<>();
    private Set<AnswerDTO> answers = new HashSet<>();
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date createdAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public Boolean getCertainty() {
        return certainty;
    }

    public void setCertainty(Boolean certainty) {
        this.certainty = certainty;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    public Set<TagDTO> getTags() {
        return tags;
    }

    public void setTags(Set<TagDTO> tags) {
        this.tags = tags;
    }

    public Set<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerDTO> answers) {
        this.answers = answers;
    }

    public Set<Long> getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Set<Long> categoriesId) {
        this.categoriesId = categoriesId;
    }

    public Set<Long> getTagsId() {
        return tagsId;
    }

    public void setTagsId(Set<Long> tagsId) {
        this.tagsId = tagsId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
