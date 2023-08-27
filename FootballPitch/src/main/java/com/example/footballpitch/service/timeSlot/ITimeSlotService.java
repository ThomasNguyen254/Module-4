package com.example.footballpitch.service;

import com.example.footballpitch.model.FootballPitch;
import com.example.footballpitch.model.TimeSlot;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ITimeSlotService {
    List<TimeSlot> showAll();

    Page<TimeSlot> showAll(Pageable pageable, String name);

    List<TimeSlot> searchName(String name);

    TimeSlot findById(Long id);

    void save(TimeSlot timeSlot);

    void update(TimeSlot timeSlot);

    void delete(Long id);
}
