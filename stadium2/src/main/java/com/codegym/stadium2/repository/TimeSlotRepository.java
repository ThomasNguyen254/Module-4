package com.example.stadium.repository;

import com.example.stadium.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot,Long> {
    List<Long> findAllByPrice();
}
