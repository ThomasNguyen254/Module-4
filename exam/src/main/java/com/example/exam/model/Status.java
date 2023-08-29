package com.example.exam.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "status")
    private Set<Question> questionSet;

    public Status() {
    }

    public Status(Long id, String name, Set<Question> questionSet) {
        this.id = id;
        this.name = name;
        this.questionSet = questionSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }
}
