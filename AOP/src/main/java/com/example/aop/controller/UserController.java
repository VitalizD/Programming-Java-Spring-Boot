package com.example.aop.controller;

import com.example.aop.annotation.CheckMax;
import com.example.aop.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CheckMax
    @GetMapping("/count")
    public String getRequestsCount() {
        return "Completed requests: " + userService.IncAndGetRequestsCount();
    }
}
