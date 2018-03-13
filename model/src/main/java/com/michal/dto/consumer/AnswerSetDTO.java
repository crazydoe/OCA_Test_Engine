package com.michal.dto.consumer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class AnswerSetDTO {

    private Set<AnswerUserDTO> answers = new HashSet<>();

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long questionSetId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long scorePercentage;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long correctlyAnsweredCount = 0L;

    public Set<AnswerUserDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerUserDTO> answers) {
        this.answers = answers;
    }

    public Long getScorePercentage() {
        return scorePercentage;
    }

    public void setScorePercentage(Long scorePercentage) {
        this.scorePercentage = scorePercentage;
    }

    public Long getCorrectlyAnsweredCount() {
        return correctlyAnsweredCount;
    }

    public void setCorrectlyAnsweredCount(Long correctlyAnsweredCount) {
        this.correctlyAnsweredCount = correctlyAnsweredCount;
    }

    public Long getQuestionSetId() {
        return questionSetId;
    }

    public AnswerSetDTO setQuestionSetId(Long questionSetId) {
        this.questionSetId = questionSetId;
        return this;
    }

    public AnswerSetDTO addAnswer(AnswerUserDTO answer) {
        answers.add(answer);
        return this;
    }

    public void incrementScore() {
        correctlyAnsweredCount++;
    }
}
