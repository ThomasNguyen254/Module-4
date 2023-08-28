package com.example.fixstadium.repository;

import com.example.fixstadium.model.Area;
import com.example.fixstadium.model.Stadium;
import com.example.fixstadium.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StadiumRepository extends JpaRepository<Stadium,Long> {
    Page<Stadium> findByNameContaining(Pageable pageable,String name);
    Page<Stadium> findAllByNameContainingAndAreaAndType(Pageable pageable,String name,Area area,Type type);
    Page<Stadium> findAllByArea(Pageable pageable,Area area);
    Page<Stadium> findAllByType(Pageable pageable,Type type);
    List<Stadium> findAllByArea(Area area);
}
