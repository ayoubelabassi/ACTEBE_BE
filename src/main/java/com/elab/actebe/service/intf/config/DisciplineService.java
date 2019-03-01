package com.elab.actebe.service.intf.config;

import com.elab.actebe.service.dto.config.DisciplineDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DisciplineService {
    DisciplineDTO save(DisciplineDTO disciplineDTO);

    List<DisciplineDTO> findAll();

    DisciplineDTO findOne(long id);
}
