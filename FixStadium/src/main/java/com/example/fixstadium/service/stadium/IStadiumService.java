package com.example.fixstadium.service.stadium;

import com.example.fixstadium.IGeneralService;
import com.example.fixstadium.model.Area;
import com.example.fixstadium.model.Stadium;
import com.example.fixstadium.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStadiumService extends IGeneralService<Stadium> {
    Page<Stadium> findAll(Pageable pageable);

    Page<Stadium> findByNameAndAreaAndType(Pageable pageable, String name, Area area, Type type);

}
