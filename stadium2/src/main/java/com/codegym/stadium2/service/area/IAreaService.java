package com.example.stadium.service.area;

import com.example.stadium.IGeneralService;
import com.example.stadium.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAreaService extends IGeneralService<Area> {
    List<Area> findAll();
}
