package com.example.exam.service.question;

import com.example.exam.IGeneralService;
import com.example.exam.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService extends IGeneralService<Question> {
    Page<Question> findAll(Pageable pageable);

    Page<Question> findByTittleContainingAndType_NameContaining(Pageable pageable,String tittle,String type);

    Page<Question> findByTittleContaining(Pageable pageable,String tittle);

    boolean isNameUnique(String tittle);
}
