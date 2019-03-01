package com.elab.actebe.repository.config;

import com.elab.actebe.domaine.config.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline,Long> {
    List<Discipline> findAllByDeleted(boolean deleted);
}
