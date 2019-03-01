package com.elab.actebe.service.impl.security;

import com.elab.actebe.domaine.security.User;
import com.elab.actebe.repository.security.UserRepository;

import com.elab.actebe.service.intf.security.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) {
        User user=userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    @Override
    public User loadUserByUsernameAndPassword(String username, String password) {
        User user=userRepository.findUserByUsernameAndPassword(username,password);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public long usersCount() {
        long count=userRepository.count();
        return count;
    }
}
