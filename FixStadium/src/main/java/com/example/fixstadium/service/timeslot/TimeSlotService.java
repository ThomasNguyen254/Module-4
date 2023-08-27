package com.example.fixstadium.service.timeslot;

import com.example.fixstadium.model.TimeSlot;
import com.example.fixstadium.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotService implements ITimeSlotService{
    @Autowired
    TimeSlotRepository timeSlotRepository;
    @Override
    public List<TimeSlot> findAll() {
        return timeSlotRepository.findAll();
    }
}
