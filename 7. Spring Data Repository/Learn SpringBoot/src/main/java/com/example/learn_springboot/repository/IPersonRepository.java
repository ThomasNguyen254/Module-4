package com.example.learn_springboot.repository;

import com.example.learn_springboot.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPersonRepository extends JpaRepository<Person,Long> {
    List<Person> findPersonByNameContaining(String name);

    @Query(value = "select * from student where name like :searchName",nativeQuery = true)
    List<Person> searchByName (@Param("searchName") String searchName);

    Page<Person> findPersonByNameContaining(Pageable pageable,String name);
}
