package com.example.fixstadium.service.stadium;

import com.example.fixstadium.IGeneralService;
import com.example.fixstadium.model.Area;
import com.example.fixstadium.model.Stadium;
import com.example.fixstadium.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStadiumService extends IGeneralService<Stadium> {
    Page<Stadium> findAll(Pageable pageable);

    Page<Stadium> findAllByNameContainingAndAreaAndType(Pageable pageable,String name,Area area,Type type);

    Page<Stadium> findByArea(Pageable pageable,Area area);

    Page<Stadium> findAllByType(Pageable pageable,Type type);

    Page<Stadium> findByNameContaining(Pageable pageable,String name);

    List<Stadium> findAllByArea(Area area);

}
