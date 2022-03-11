package com.example.trainingproject;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("SecondRobot")
public class SecondRobot implements IRobot {

    public SecondRobot() {}

    @Override
    public String say() {
        return "I'm Robot number two";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Second Robot was created!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Second Robot was destroyed!");
    }

}
