package com.example.footballpitch.service;

import com.example.footballpitch.model.Area;
import com.example.footballpitch.model.FootballPitch;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IAreaService {
    List<Area> showAll();

    Page<Area> showAll(Pageable pageable, String name);

    List<Area> searchName(String name);

    Area findById(Long id);

    void save(Area area);

    void update(Area area);

    void delete(Long id);
}
