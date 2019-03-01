package com.elab.actebe.service.impl.project;

import com.elab.actebe.domaine.project.Plan;
import com.elab.actebe.repository.project.PlanRepository;
import com.elab.actebe.service.intf.project.PlanService;
import com.elab.actebe.service.dto.project.PlanDTO;
import com.elab.actebe.service.mapper.project.PlanMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Inject
    private PlanRepository planRepository;

    @Inject
    private PlanMapper planMapper;

    @Override
    public PlanDTO save(PlanDTO planDTO) {
        Plan plan = planMapper.PlanDTOToPlan(planDTO);
        plan = planRepository.save(plan);
        return planMapper.PlanToPlanDTO(plan);
    }

    @Override
    public List<PlanDTO> readAll() {
        return planMapper.PlansToPlanDTOs(planRepository.findAll());
    }
}
