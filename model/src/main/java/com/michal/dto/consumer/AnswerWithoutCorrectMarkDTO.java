package com.michal.dto.consumer;

import java.io.Serializable;

public class AnswerWithoutCorrectMarkDTO implements Serializable{

    private static final long serialVersionUID = 2L;

    private Long id;
    private String body;
    private String explanation;

    public Long getId() { return id; }

    public AnswerWithoutCorrectMarkDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBody() { return body; }

    public AnswerWithoutCorrectMarkDTO setBody(String body) {
        this.body = body;
        return this;
    }

    public String getExplanation() { return explanation; }

    public AnswerWithoutCorrectMarkDTO setExplanation(String explanation) {
        this.explanation = explanation;
        return this;
    }

}
