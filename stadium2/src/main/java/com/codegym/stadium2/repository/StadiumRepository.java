package com.example.stadium.repository;

import com.example.stadium.model.Stadium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium,Long> {
    Stadium findByName(String name);
    Page<Stadium> findByNameContainingAndAreaAndPeopleAmount(Pageable pageable,String name,String area,String peopleAmount);
}
