package com.elab.actebe.service.mapper.project;


import com.elab.actebe.domaine.project.Revision;
import com.elab.actebe.service.dto.project.RevisionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RevisionMapper {
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    Revision RevisionDTOToRevision(RevisionDTO RevisionDTO);
    @Mapping(source = "createdBy.name", target = "createdBy")
    @Mapping(source = "updatedBy.name", target = "updatedBy")
    RevisionDTO RevisionToRevisionDTO(Revision Revision);

    List<Revision> RevisionDTOsToRevisions(List<RevisionDTO> RevisionDTOS);

    List<RevisionDTO> RevisionsToRevisionDTOs(List<Revision> RevisionS);
}
