package com.michal.dto.consumer;

import com.michal.model.enums.AnswerType;
import com.michal.model.enums.BodyType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class QuestionSendToUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String body;
    private String footer;
    private BodyType bodyType;
    private AnswerType answerType;
    private Set<AnswerWithoutCorrectMarkDTO> answers = new HashSet<>();

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

    public Set<AnswerWithoutCorrectMarkDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerWithoutCorrectMarkDTO> answers) {
        this.answers = answers;
    }
}
