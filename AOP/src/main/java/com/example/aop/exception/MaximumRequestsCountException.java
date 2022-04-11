package com.example.aop.exception;

import lombok.Getter;

@Getter
public class MaximumRequestsCountException extends Exception {
    private int maxCount;

    public MaximumRequestsCountException(String message, int maxCount) {
        super(message);
        this.maxCount = maxCount;
    }
}
