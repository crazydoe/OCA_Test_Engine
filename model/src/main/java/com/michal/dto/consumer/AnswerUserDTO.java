package com.michal.dto.consumer;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class AnswerUserDTO {

    @NotNull
    private Long questionId;
    @NotNull
    private Set<Long> selectedId = new HashSet<>();
    private Set<Long> correctId = new HashSet<>();
    private Boolean passed = false;

    public Long getQuestionId() {
        return questionId;
    }

    public AnswerUserDTO setQuestionId(Long questionId) {
        this.questionId = questionId;
        return this;
    }

    public Set<Long> getSelectedId() {
        return selectedId;
    }

    public AnswerUserDTO setSelectedId(Set<Long> selectedId) {
        this.selectedId = selectedId;
        return this;
    }

    public Set<Long> getCorrectId() {
        return correctId;
    }

    public AnswerUserDTO setCorrectId(Set<Long> correctId) {
        this.correctId = correctId;
        return this;
    }

    public Boolean getPassed() {
        return passed;
    }

    public AnswerUserDTO setPassed(Boolean passed) {
        this.passed = passed;
        return this;
    }

    public AnswerUserDTO addCorrectId(Long id) {
        correctId.add(id);
        return this;
    }


}
