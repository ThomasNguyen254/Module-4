package com.example.footballpitch.service;

import com.example.footballpitch.model.FootballPitch;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IFootballPitchService {
    Iterable<FootballPitch> findAll();

    Page<FootballPitch> findAll(Pageable pageable, String name);

    List<FootballPitch> searchName(String name);

    Optional<FootballPitch> findById(Long id);

    void save(FootballPitch footballPitch);

    void delete(Long id);
}
