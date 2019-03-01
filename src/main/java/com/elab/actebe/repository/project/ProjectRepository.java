package com.elab.actebe.repository.project;

import com.elab.actebe.domaine.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
