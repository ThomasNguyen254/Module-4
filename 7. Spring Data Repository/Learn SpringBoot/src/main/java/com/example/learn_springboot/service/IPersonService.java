package com.example.learn_springboot.service;

import com.example.learn_springboot.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPersonService {
    List<Person> findAll();

    Page<Person> findAll(Pageable pageable,String name);

    boolean save(Person person);

    boolean update(Long id,Person person);

    boolean delete(Long id);

    Optional<Person> findById(Long id);


}
