package com.codegym.blogapi.repository;

import com.codegym.blogapi.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogServiceRepository extends JpaRepository<Blog,Long> {
}
