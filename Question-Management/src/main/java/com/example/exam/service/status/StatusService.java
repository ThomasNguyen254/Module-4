package com.example.exam.service.status;

import com.example.exam.model.Status;
import com.example.exam.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements IStatusService{
    @Autowired
    StatusRepository statusRepository;


    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
