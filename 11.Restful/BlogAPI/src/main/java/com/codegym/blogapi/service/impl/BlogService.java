package com.codegym.blogapi.service.impl;

import com.codegym.blogapi.model.Blog;
import com.codegym.blogapi.repository.IBlogServiceRepository;
import com.codegym.blogapi.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogServiceRepository blogServiceRepository;
    @Override
    public Iterable<Blog> findAll() {
        return blogServiceRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogServiceRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogServiceRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogServiceRepository.deleteById(id);
    }
}
