package com.example.stadium.service.timeSlot;

import com.example.stadium.IGeneralService;
import com.example.stadium.model.TimeSlot;

import java.util.List;

public interface ITimeSlotService extends IGeneralService<TimeSlot> {
    List<TimeSlot> findAll();
    List<String> priceList();
}
