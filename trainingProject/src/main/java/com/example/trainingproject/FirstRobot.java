package com.example.trainingproject;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class FirstRobot implements IRobot {

    public FirstRobot() {}

    @Override
    public String say() {
        return "I'm Robot number one";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("First Robot was created!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("First Robot was destroyed!");
    }

}
