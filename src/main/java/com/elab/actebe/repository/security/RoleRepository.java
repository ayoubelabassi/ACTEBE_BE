package com.elab.actebe.repository.security;

import com.elab.actebe.domaine.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
