package com.elab.actebe.service.mapper.project;

import com.elab.actebe.domaine.project.Project;
import com.elab.actebe.service.dto.project.ProjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(source = "createdBy.name", target = "createdBy")
    @Mapping(source = "updatedBy.name", target = "updatedBy")
    @Mapping(source = "category.id", target = "category")
    @Mapping(source = "category.name", target = "categoryName")
    ProjectDTO ProjectToProjectDTO(Project project);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(source = "category", target = "category.id")
    @Mapping(target = "plans", ignore = true)
    Project ProjectDTOtoProject(ProjectDTO projectDTO);

    List<ProjectDTO> ProjectsToProjectDTOs(List<Project> projects);

    List<Project> ProjectDTOsToProjects(List<ProjectDTO> projects);
}
