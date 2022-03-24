package com.example.trainingproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "some.test")
public class TestConfig {

    private String applicationName;
    private String environmentVariable;
    private String[] li;

    public TestConfig(String applicationName, String environmentVariable, String[] li) {
        this.applicationName = applicationName;
        this.environmentVariable = environmentVariable;
        this.li = li;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getEnvironmentVariable() {
        return environmentVariable;
    }

    public String[] getLi() {
        return li;
    }
}
