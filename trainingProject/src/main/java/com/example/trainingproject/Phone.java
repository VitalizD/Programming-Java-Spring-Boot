package com.example.trainingproject;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Phone {

    public Phone() {}

    public String call() {
        return "Incoming call...";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Phone was created!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Phone was destroyed!");
    }
}
