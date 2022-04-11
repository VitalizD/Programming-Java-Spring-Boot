package com.example.security.controller;

import com.example.security.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/public/api")
    public String publicApi() {
        return "Public access!";
    }

    @GetMapping("/admin/api")
    public String adminApi() {
        return userService.getUsernameAndAuthorities();
    }

    @GetMapping("/support/api")
    public String supportApi() {
        return userService.getUsernameAndAuthorities();
    }
}
