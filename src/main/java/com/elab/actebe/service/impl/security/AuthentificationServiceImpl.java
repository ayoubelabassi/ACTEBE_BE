package com.elab.actebe.service.impl.security;

import com.elab.actebe.domaine.impl.UserImpl;
import com.elab.actebe.domaine.security.User;
import com.elab.actebe.repository.security.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collections;

@Service
public class AuthentificationServiceImpl implements UserDetailsService {
    @Inject
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user=userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        UserImpl u=new UserImpl(user.getUsername(),user.getPassword(), Collections.emptyList());
        u.setId(user.getId());
        return u;
    }
}
