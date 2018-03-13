package com.michal.dto.common;

import com.michal.dto.consumer.QuestionSendToUserDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionSetDTO {

    private Long id;
    private Date createdAt;
    private List<QuestionSendToUserDTO> questions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public QuestionSetDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public List<QuestionSendToUserDTO> getQuestions() {
        return questions;
    }

    public QuestionSetDTO setQuestions(List<QuestionSendToUserDTO> questions) {
        this.questions = questions;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public QuestionSetDTO setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
