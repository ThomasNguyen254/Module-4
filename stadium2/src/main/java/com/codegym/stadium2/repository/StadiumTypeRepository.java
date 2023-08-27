package com.example.stadium.repository;

import com.example.stadium.model.StadiumType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumTypeRepository extends JpaRepository<StadiumType,Long> {
}
