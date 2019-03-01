package com.elab.actebe.repository.config;

import com.elab.actebe.domaine.config.Function;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FunctionRepository extends JpaRepository<Function, Long> {
    List<Function> getAllByDeleted(boolean deleted);
}
