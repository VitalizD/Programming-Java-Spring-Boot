package com.example.aop.aspect;

import com.example.aop.config.RequestConfig;
import com.example.aop.exception.MaximumRequestsCountException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableConfigurationProperties(RequestConfig.class)
public class CheckMaxAspect {
    private final int maxRequestsCount;

    private CheckMaxAspect(RequestConfig requestConfig) {
        maxRequestsCount = requestConfig.getMaxCount();
    }

    @AfterReturning(value = "within(com.example.aop.service.UserService) && " +
            "@annotation(com.example.aop.annotation.CheckMax)", returning = "result")
    public void checkRequestsCount(Object result) throws Throwable {
        if ((int)result > maxRequestsCount)
            throw new MaximumRequestsCountException(
                    "The maximum number of requests has been reached (" + maxRequestsCount + ")", maxRequestsCount);
    }
}
