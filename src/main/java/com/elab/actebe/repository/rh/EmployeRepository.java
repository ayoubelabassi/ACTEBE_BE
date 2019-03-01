package com.elab.actebe.repository.rh;

import com.elab.actebe.domaine.rh.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
