package com.example.trainingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class TrainingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingProjectApplication.class, args);
    }

}
