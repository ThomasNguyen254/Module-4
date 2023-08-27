package com.example.stadium.service.area;

import com.example.stadium.model.Area;
import com.example.stadium.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AreaService implements IAreaService{
    @Autowired
    AreaRepository areaRepository;
    @Override
    public Optional<Area> findById(Long id) {
        return areaRepository.findById(id);
    }

    @Override
    public void save(Area area) {
        areaRepository.save(area);

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }
}
