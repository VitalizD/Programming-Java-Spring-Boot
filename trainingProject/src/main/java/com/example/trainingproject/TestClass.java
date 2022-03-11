package com.example.trainingproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TestClass {

    private Calculator calculator;
    private Phone phone;
    @Autowired private Glados glagos;
    private IRobot firstRobot;
    private IRobot secondRobot;

    @Autowired
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public TestClass(Calculator calculator, @Qualifier("firstRobot") IRobot firstRobot, IRobot SecondRobot) {
        this.calculator = calculator;
        this.firstRobot = firstRobot;
        this.secondRobot = SecondRobot;
    }

    public void execute() {
        System.out.println("5 + 10 = " + calculator.execute(5, 10, '+'));
        System.out.println(glagos.welcome());
        System.out.println(phone.call());
        System.out.println(firstRobot.say());
        System.out.println(secondRobot.say());
    }

}
