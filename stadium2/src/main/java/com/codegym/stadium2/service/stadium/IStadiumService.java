package com.example.stadium.service.stadium;

import com.example.stadium.IGeneralService;
import com.example.stadium.model.Stadium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStadiumService extends IGeneralService<Stadium> {
    Page<Stadium> findAll(Pageable pageable);
    Page<Stadium> findByNameContainingAndAreaAndPeopleAmount(Pageable pageable,String name,String area,String peopleAmount);
}
