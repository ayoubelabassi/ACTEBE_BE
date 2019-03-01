package com.elab.actebe.repository.config;

import com.elab.actebe.domaine.config.Entite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntiteRepository extends JpaRepository<Entite,Long> {
}
