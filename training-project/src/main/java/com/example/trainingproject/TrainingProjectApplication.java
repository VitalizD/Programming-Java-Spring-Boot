package com.example.trainingproject;

import com.example.trainingproject.controllers.EventController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingProjectApplication {
    private static EventController controller;

    public TrainingProjectApplication(EventController controller) {
        TrainingProjectApplication.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(TrainingProjectApplication.class, args);
        controller.TriggerOnAsyncEvent();
        controller.TriggerOnSyncEvent();
        controller.TriggerOnTransactionalEvent();
    }
}
