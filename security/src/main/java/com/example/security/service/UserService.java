package com.example.security.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUser() {
        return (User)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public String getUsernameAndAuthorities() {
        var user = getUser();
        return "Username: " + user.getUsername() + "\n" +
                "Authorities: " + user.getAuthorities();
    }
}
