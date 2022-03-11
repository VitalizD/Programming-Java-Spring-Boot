package com.example.trainingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingProjectApplication {

    private static TestClass test;

    public TrainingProjectApplication(TestClass test) {
        TrainingProjectApplication.test = test;
    }

    public static void main(String[] args) {
        SpringApplication.run(TrainingProjectApplication.class, args);
        test.execute();
    }

}
