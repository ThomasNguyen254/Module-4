package com.example.learn_springboot.service;

import com.example.learn_springboot.model.Person;
import com.example.learn_springboot.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService{
    @Autowired
    IPersonRepository personRepository;
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public boolean save(Person person) {
        Person newPerson = personRepository.save(person);
        if (newPerson != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Long id, Person person) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Page<Person> findAll(Pageable pageable,String name) {
        return personRepository.findPersonByNameContaining(pageable,name);
    }

}
