package com.example.stadium.service.timeSlot;

import com.example.stadium.FormatUtils;
import com.example.stadium.model.TimeSlot;
import com.example.stadium.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSlotService implements ITimeSlotService {
    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Override
    public Optional<TimeSlot> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(TimeSlot timeSlot) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<TimeSlot> findAll() {
        return timeSlotRepository.findAll();
    }

    @Override
    public List<String> priceList() {
        List<Long> oldList = timeSlotRepository.findAllByPrice();
        List<String> formatList = new ArrayList<>();
        for (long num : oldList) {
            formatList.add(FormatUtils.formatPrice(num));
        }
        return formatList;
    }
}
