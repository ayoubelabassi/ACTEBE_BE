package com.elab.actebe.repository.project;

import com.elab.actebe.domaine.project.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision,Long> {
}
