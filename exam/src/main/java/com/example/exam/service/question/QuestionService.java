package com.example.exam.service.question;

import com.example.exam.model.Question;
import com.example.exam.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService{
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);

    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);

    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Page<Question> findByTittleContainingAndType_NameContaining(Pageable pageable, String tittle, String type) {
        return questionRepository.findByTittleContainingAndType_NameContaining(pageable,tittle,type);
    }


    @Override
    public Page<Question> findByTittleContaining(Pageable pageable, String tittle) {
        return questionRepository.findByTittleContaining(pageable,tittle);
    }

    @Override
    public boolean isNameUnique(String title) {
        Question existingStadium = questionRepository.findByTittle(title);
        return existingStadium == null;
    }
}
