package com.michal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String body;
    private Boolean correct;
    private String explanation;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Long getId() { return id; }

    public Answer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBody() { return body; }

    public Answer setBody(String body) {
        this.body = body;
        return this;
    }

    public Boolean getCorrect() { return correct; }

    public Answer setCorrect(Boolean correct) {
        this.correct = correct;
        return this;
    }

    public String getExplanation() { return explanation; }

    public Answer setExplanation(String explanation) {
        this.explanation = explanation;
        return this;
    }

    public Question getQuestion() { return question; }

    public Answer setQuestion(Question question) {
        this.question = question;
        return this;
    }
}
