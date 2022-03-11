package com.example.trainingproject;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Calculator {

    public Calculator() {}

    public int execute(int first, int second, char operand) {
        switch (operand) {
            case '+': return first + second;
            case '-': return first - second;
            case '*': return first * second;
            case '/': return first / second;
        }
        return -1;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Calculator was created!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Calculator was destroyed!");
    }

}
