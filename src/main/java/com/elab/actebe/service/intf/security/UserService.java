package com.elab.actebe.service.intf.security;

import com.elab.actebe.domaine.security.User;

public interface UserService {
    User loadUserByUsername(String username);
    User loadUserByUsernameAndPassword(String username, String password);
    User saveUser(User user);
    long usersCount();
}
