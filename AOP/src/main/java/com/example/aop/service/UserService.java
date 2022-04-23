package com.example.aop.service;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private int currentRequestsCount = 0;
    private int visitsCount = 0;

    @Timed(value = "getRequestsCount.time")
    @Counted(value = "getRequestsCount.count")
    public int IncAndGetRequestsCount() {
        return ++currentRequestsCount;
    }

    @Scheduled(fixedRate = 3000)
    @Counted(value = "visits.count", description = "The number of user visits to the specified address")
    public void addVisit() {
        ++visitsCount;
    }
}
