package com.michal.model.entity;

import com.michal.model.enums.BodyType;
import com.michal.model.enums.AnswerType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    private String footer;
    private Boolean certainty;
    private Boolean visible;

    @Column(name = "body_type")
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;
    @Column(name = "answer_type")
    @Enumerated(EnumType.STRING)
    private AnswerType answerType;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "question_category",
            joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> categories = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "question_tag",
            joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER,
            targetEntity = Answer.class, orphanRemoval = true)
    private Set<Answer> answers = new HashSet<>();

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt; // TODO sprawdzić dlaczego nie wyciąga daty z bazy


    public Long getId() {
        return id;
    }

    public Question setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Question setBody(String body) {
        this.body = body;
        return this;
    }

    public String getFooter() {
        return footer;
    }

    public Question setFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public Question setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public Question setAnswers(Set<Answer> answers) {
        this.answers = answers;
        return this;
    }

    public Question addAnswer(Answer answer) {
        answer.setQuestion(this);
        return this;
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

    public AnswerType getAnswerType() {
        return answerType;
    }

    public Question setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Question setTags(Set<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Question setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }
}