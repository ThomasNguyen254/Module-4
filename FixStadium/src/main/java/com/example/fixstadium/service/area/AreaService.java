package com.example.fixstadium.service.area;

import com.example.fixstadium.model.Area;
import com.example.fixstadium.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService implements  IAreaService{
    @Autowired
    AreaRepository areaRepository;
    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }
}
