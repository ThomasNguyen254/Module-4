package com.example.stadium.service.stadiumType;

import com.example.stadium.model.StadiumType;
import com.example.stadium.repository.StadiumRepository;
import com.example.stadium.repository.StadiumTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StadiumTypeService implements IStadiumTypeService{
    @Autowired
    StadiumTypeRepository stadiumTypeRepository;
    @Override
    public Optional<StadiumType> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(StadiumType stadiumType) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<StadiumType> findAll() {
        return stadiumTypeRepository.findAll();
    }
}
