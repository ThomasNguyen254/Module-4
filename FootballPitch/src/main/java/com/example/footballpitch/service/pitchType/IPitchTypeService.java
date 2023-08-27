package com.example.footballpitch.service;

import com.example.footballpitch.model.FootballPitch;
import com.example.footballpitch.model.PitchType;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IPitchTypeService {
    List<PitchType> showAll();

    Page<PitchType> showAll(Pageable pageable, String name);

    List<PitchType> searchName(String name);

    PitchType findById(Long id);

    void save(PitchType pitchType);

    void update(PitchType pitchType);

    void delete(Long id);
}
