package com.elab.actebe.service.mapper.config;

import com.elab.actebe.domaine.config.Discipline;
import com.elab.actebe.service.dto.config.DisciplineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplineMapper {
    @Mapping(source = "createdBy.name", target = "createdBy")
    @Mapping(source = "updatedBy.name", target = "updatedBy")
    DisciplineDTO DisciplineToDisciplineDTO(Discipline Discipline);

    List<DisciplineDTO> DisciplinesToDisciplineDTOs(List<Discipline> Disciplines);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    Discipline DisciplineDTOtoDiscipline(DisciplineDTO DisciplineDTO);

    List<Discipline> DisciplineDTOsToDisciplines(List<DisciplineDTO> Disciplines);

}
