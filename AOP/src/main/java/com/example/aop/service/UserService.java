package com.example.aop.service;

import com.example.aop.annotation.CheckMax;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private int currentRequestsCount = 0;

    @CheckMax
    public int IncAndGetRequestsCount() {
        return ++currentRequestsCount;
    }
}
