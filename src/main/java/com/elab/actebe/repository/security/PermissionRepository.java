package com.elab.actebe.repository.security;

import com.elab.actebe.domaine.security.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
