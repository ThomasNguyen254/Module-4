package com.example.footballpitch.service.impl;

import com.example.footballpitch.model.FootballPitch;
import com.example.footballpitch.repository.FootBallPitchRepository;
import com.example.footballpitch.service.IFootballPitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class FootBallPitchService implements IFootballPitchService {
    @Autowired
    FootBallPitchRepository footBallPitchRepository;

    @Override
    public Iterable<FootballPitch> findAll() {
        return footBallPitchRepository.findAll();
    }

    @Override
    public Page<FootballPitch> findAll(Pageable pageable, String name) {
        return footBallPitchRepository.findByNameContaining(pageable,name);
    }

    @Override
    public List<FootballPitch> searchName(String name) {
        return footBallPitchRepository.findByNameContaining(name);
    }

    @Override
    public Optional<FootballPitch> findById(Long id) {
        return footBallPitchRepository.findById(id);
    }

    @Override
    public void save(FootballPitch footballPitch) {
        footBallPitchRepository.save(footballPitch);

    }

    @Override
    public void delete(Long id) {
        footBallPitchRepository.delete(id);

    }
}
