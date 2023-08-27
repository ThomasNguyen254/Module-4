package com.example.stadium.service.stadium;

import com.example.stadium.model.Stadium;
import com.example.stadium.repository.StadiumRepository;
import com.example.stadium.repository.StadiumTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StadiumService implements IStadiumService{
    @Autowired
    StadiumRepository stadiumRepository;
    @Override
    public Iterable<Stadium> findAll() {
        return stadiumRepository.findAll();
    }

    @Override
    public Optional<Stadium> findById(Long id) {
        return stadiumRepository.findById(id);
    }

    @Override
    public void save(Stadium stadium) {
        stadiumRepository.save(stadium);

    }

    @Override
    public void remove(Long id) {
        stadiumRepository.deleteById(id);

    }

    @Override
    public Page<Stadium> findAll(Pageable pageable) {
        return stadiumRepository.findAll(pageable);
    }

    @Override
    public Page<Stadium> findByNameContainingAndAreaAndPeopleAmount(Pageable pageable, String name, String area, String peopleAmount) {
        return stadiumRepository.findByNameContainingAndAreaAndPeopleAmount(pageable,name,area,peopleAmount);
    }
}
