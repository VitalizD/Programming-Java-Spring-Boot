package com.example.trainingproject;

import com.example.trainingproject.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TrainingProjectApplication {
    private static UserController controller;

    public TrainingProjectApplication(UserController controller) {
        TrainingProjectApplication.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(TrainingProjectApplication.class, args);
        controller.TriggerOnAsyncEvent();
        controller.TriggerOnSyncEvent();
        controller.TriggerOnTransactionalEvent();
    }
}
