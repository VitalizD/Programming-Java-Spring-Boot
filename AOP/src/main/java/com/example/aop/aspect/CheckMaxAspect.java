package com.example.aop.aspect;

import com.example.aop.config.RequestConfig;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableConfigurationProperties(RequestConfig.class)
public class CheckMaxAspect {
    private final int maxRequestsCount;
    private int currentRequestsCount = 0;

    private CheckMaxAspect(RequestConfig requestConfig) {
        maxRequestsCount = requestConfig.getMaxCount();
    }

    @Around(value = "within(com.example.aop.controller.UserController) && " +
            "@annotation(com.example.aop.annotation.CheckMax)")
    public Object checkRequestsCount(ProceedingJoinPoint point) throws Throwable {
        Object returnValue = null;
        if (currentRequestsCount++ < maxRequestsCount) {
            returnValue = point.proceed();
        }
        return returnValue;
    }
}
