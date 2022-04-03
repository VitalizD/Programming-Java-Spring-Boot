package com.example.trainingproject;

import com.example.trainingproject.publishers.EventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TrainingProjectApplication {
    private static EventPublisher controller;

    public TrainingProjectApplication(EventPublisher controller) {
        TrainingProjectApplication.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(TrainingProjectApplication.class, args);
        controller.TriggerOnAsyncEvent();
        controller.TriggerOnSyncEvent();
        controller.TriggerOnTransactionalEvent();
    }
}
