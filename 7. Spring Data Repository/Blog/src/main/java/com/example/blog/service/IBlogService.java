package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable,String name);

    List<Blog> searchName(String name);

    Blog findById(int id);

    boolean save(Blog blog);

    boolean delete(int id);

    boolean update(Blog blog);

}
