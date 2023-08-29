package com.example.exam.repository;

import com.example.exam.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findByTittle(String tittle);

    Page<Question> findByTittleContaining(Pageable pageable, String name);

    Page<Question> findByTittleContainingAndType_NameContaining(Pageable pageable,String tittle,String type);
}
