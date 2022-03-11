package com.example.trainingproject;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Glados {

    public Glados() {}

    public String welcome() {
        return "Hello, and welcome again to the Aperture Science Automated Enrichment Center!";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("GLaDOS was created!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("GLaDOS was destroyed!");
    }

}
