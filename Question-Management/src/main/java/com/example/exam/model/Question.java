package com.example.exam.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String postDate;

    @ManyToOne
    @JoinColumn(name="type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name="status_id")
    private Status status;

    public Question() {
    }

    public Question(Long id, String tittle, String postDate, Type type, Status status) {
        this.id = id;
        this.tittle = tittle;
        this.postDate = postDate;
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
