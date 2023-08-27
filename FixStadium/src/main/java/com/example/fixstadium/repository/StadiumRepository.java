package com.example.fixstadium.repository;

import com.example.fixstadium.model.Area;
import com.example.fixstadium.model.Stadium;
import com.example.fixstadium.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium,Long> {
    Page<Stadium> findByName(Pageable pageable,String name);
    Page<Stadium> findByNameAndAreaAndType(Pageable pageable, String name,Area area,Type type);
}
