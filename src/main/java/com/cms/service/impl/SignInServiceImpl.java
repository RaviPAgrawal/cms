package com.cms.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cms.model.Role;
import com.cms.model.User;
import com.cms.service.SignInService;
import com.cms.service.UserService;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UserService userService;

    @Override
    public void signInUser(String email) {
        User user = userService.findUserByEmail(email);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getEmail(), null, getGrantedAuthorities(user.getRoles())));
    }

    private Set<GrantedAuthority> getGrantedAuthorities(Set<Role> roles) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().toString()));
        }
        return grantedAuthorities;
    }
}
