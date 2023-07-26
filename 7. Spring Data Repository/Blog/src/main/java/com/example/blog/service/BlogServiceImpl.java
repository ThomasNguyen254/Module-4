package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService{
    @Autowired
    IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String name) {
        return blogRepository.findBlogByNameContaining(pageable,name);
    }

    @Override
    public List<Blog> searchName(String name) {
        return blogRepository.searchByName("%" + name + "%");
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Blog blog) {
        Blog newBlog = blogRepository.save(blog);
        if(newBlog != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
       Blog delBlog = findById(id);
       if(delBlog != null) {
           return true;
       }
       return false;
    }

    @Override
    public boolean update(Blog blog) {
        return false;
    }
}
