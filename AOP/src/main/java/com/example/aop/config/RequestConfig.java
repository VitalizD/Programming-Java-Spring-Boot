package com.example.aop.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "request")
public class RequestConfig {
    private int maxCount;

    public RequestConfig(int maxCount) {
        this.maxCount = maxCount;
    }
}
