package com.elab.actebe.repository;

import com.elab.actebe.domaine.speaker.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Speaker,Long> {
}
