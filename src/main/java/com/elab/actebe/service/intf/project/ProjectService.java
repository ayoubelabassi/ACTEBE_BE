package com.elab.actebe.service.intf.project;

import com.elab.actebe.domaine.project.Project;
import com.elab.actebe.service.dto.project.ProjectDTO;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    List<ProjectDTO> readAll();
}
