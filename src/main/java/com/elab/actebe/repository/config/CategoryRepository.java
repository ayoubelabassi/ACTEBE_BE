package com.elab.actebe.repository.config;

import com.elab.actebe.domaine.config.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllByDeleted(boolean deleted);
}
