package com.codegym.blogapi.service.impl;

import com.codegym.blogapi.repository.ICategoryRepository;
import com.codegym.blogapi.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Category implements ICategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Iterable<com.codegym.blogapi.model.Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<com.codegym.blogapi.model.Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public com.codegym.blogapi.model.Category save(com.codegym.blogapi.model.Category category) {
        return save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
