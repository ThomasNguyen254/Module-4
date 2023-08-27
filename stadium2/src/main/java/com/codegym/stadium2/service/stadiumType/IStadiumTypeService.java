package com.example.stadium.service.stadiumType;

import com.example.stadium.IGeneralService;
import com.example.stadium.model.StadiumType;

import java.util.List;

public interface IStadiumTypeService extends IGeneralService<StadiumType> {
    List<StadiumType> findAll();
}
