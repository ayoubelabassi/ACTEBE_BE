package com.elab.actebe.web.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.elab.actebe.domaine.security.User;
import com.elab.actebe.service.intf.security.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static com.elab.actebe.util.Globals.HEADER_STRING;
import static com.elab.actebe.util.Globals.TOKEN_PREFIX;
import static com.elab.actebe.util.Globals.SECRET;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authManager, UserService userService) {
        super(authManager);
        this.userService=userService;
    }

    @Inject
    private UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        /*
        User u=new User();
        if(bCryptPasswordEncoder==null)
            bCryptPasswordEncoder=new BCryptPasswordEncoder();
        u.setPassword(bCryptPasswordEncoder.encode("admin"));
        u.setUsername("admin");
        userService.saveUser(u);
        */

        String header = req.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        User user=userService.loadUserByUsername(authentication.getPrincipal().toString());
        if(user!=null){
            Authentication auth=new UsernamePasswordAuthenticationToken(user,user.getPassword(), Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(auth);

        }else{
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }


        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
