package com.elab.actebe.config;

import com.elab.actebe.domaine.security.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public class AuditorAwareImpl implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
        User u=null;
        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            u=(User) auth.getPrincipal();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return Optional.ofNullable(u);
    }
}
