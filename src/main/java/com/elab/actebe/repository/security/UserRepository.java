package com.elab.actebe.repository.security;

import com.elab.actebe.domaine.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username,String password);
}
