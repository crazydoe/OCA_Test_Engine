package com.michal.model.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "question_set")
public class QuestionSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "question_set_category",
            joinColumns = @JoinColumn(name = "question_set_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> categories = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "question_set_tag",
            joinColumns = @JoinColumn(name = "question_set_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<Tag> tags = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "question_set_question",
            joinColumns = @JoinColumn(name = "question_set_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id")
    )
    private List<Question> questions = new ArrayList<>();

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt; // TODO sprawdzić dlaczego nie wyciąga daty z bazy

    private boolean random = false;

    public Long getId() {
        return id;
    }

    public QuestionSet setId(Long id) {
        this.id = id;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public QuestionSet setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public QuestionSet setTags(Set<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public QuestionSet setQuestions(List<Question> questions) {
        this.questions = questions;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public QuestionSet setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public boolean isRandom() {
        return random;
    }

    public QuestionSet setRandom(boolean random) {
        this.random = random;
        return this;
    }


}
