package com.elab.actebe.service.impl.project;

import com.elab.actebe.domaine.project.Project;
import com.elab.actebe.repository.project.ProjectRepository;
import com.elab.actebe.service.intf.project.ProjectService;
import com.elab.actebe.service.dto.project.ProjectDTO;
import com.elab.actebe.service.mapper.project.ProjectMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Inject
    private ProjectRepository projectRepository;

    @Inject
    private ProjectMapper projectMapper;


    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<ProjectDTO> readAll() {

        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOS=new ArrayList<>();
        for (Project p:projects) {
            projectDTOS.add(projectMapper.ProjectToProjectDTO(p));
        }

        projectDTOS=projectMapper.ProjectsToProjectDTOs(projects);
        return projectDTOS;
    }
}
