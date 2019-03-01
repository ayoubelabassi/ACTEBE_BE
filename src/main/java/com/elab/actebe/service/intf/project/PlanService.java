package com.elab.actebe.service.intf.project;

import com.elab.actebe.service.dto.project.PlanDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanService {

    PlanDTO save(PlanDTO planDTO);

    List<PlanDTO> readAll();
}
