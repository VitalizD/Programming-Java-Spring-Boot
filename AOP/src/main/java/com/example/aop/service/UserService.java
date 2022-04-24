package com.example.aop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private int currentRequestsCount = 0;

    public int IncAndGetRequestsCount() {
        return ++currentRequestsCount;
    }
}
