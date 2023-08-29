package com.example.exam.dto;

import com.example.exam.model.Status;
import com.example.exam.model.Type;
import com.example.exam.service.question.IQuestionService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class QuestionDto implements Validator {
    private Long id;
    private String tittle;
    private String postDate;
    private Type type;
    private Status status;

    public QuestionDto() {
    }

    public QuestionDto(Long id, String tittle, String postDate, Type type, Status status) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public void validateNameUnique(IQuestionService questionService, Errors errors) {
        if (!questionService.isNameUnique(tittle)) {
            errors.rejectValue("tittle", "error.stadiumDto", "Tên câu hỏi đã tồn tại.");
        }
    }
}
