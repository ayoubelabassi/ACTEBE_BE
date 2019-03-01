package com.elab.actebe.service.mapper.project;

import com.elab.actebe.domaine.project.Plan;
import com.elab.actebe.service.dto.project.PlanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanMapper {
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "revisions", ignore = true)
    @Mapping(source = "project_id", target = "project.id")
    Plan PlanDTOToPlan(PlanDTO PlanDTO);

    @Mapping(source = "createdBy.name", target = "createdBy")
    @Mapping(source = "updatedBy.name", target = "updatedBy")
    @Mapping(source = "project.id", target = "project_id")
    PlanDTO PlanToPlanDTO(Plan Plan);

    List<Plan> PlanDTOsToPlans(List<PlanDTO> PlanDTOS);

    List<PlanDTO> PlansToPlanDTOs(List<Plan> PlanS);
}
