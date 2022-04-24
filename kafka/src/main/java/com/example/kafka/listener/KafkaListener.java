package com.example.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListener {
    @org.springframework.kafka.annotation.KafkaListener(topics = "myMessages")
    public void listenMessages(String message) {
        log.info("Received message from Kafka: " + message);
    }
}
