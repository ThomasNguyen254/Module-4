package com.example.fixstadium.service.stadium;

import com.example.fixstadium.model.Area;
import com.example.fixstadium.model.Stadium;
import com.example.fixstadium.model.Type;
import com.example.fixstadium.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Page<Stadium> findAllByNameContainingAndAreaAndType(Pageable pageable, String name, Area area, Type type) {
        return stadiumRepository.findAllByNameContainingAndAreaAndType(pageable,name,area,type);
    }

    @Override
    public Page<Stadium> findByArea(Pageable pageable, Area area) {
        return stadiumRepository.findAllByArea(pageable, area);
    }

    @Override
    public Page<Stadium> findAllByType(Pageable pageable, Type type) {
        return stadiumRepository.findAllByType(pageable,type);
    }

    @Override
    public Page<Stadium> findByNameContaining(Pageable pageable, String name) {
        return stadiumRepository.findByNameContaining(pageable,name);
    }

    @Override
    public List<Stadium> findAllByArea(Area area) {
        return stadiumRepository.findAllByArea(area);
    }

}
