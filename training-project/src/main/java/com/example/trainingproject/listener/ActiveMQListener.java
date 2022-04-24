package com.example.trainingproject.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActiveMQListener {
    @JmsListener(destination = "messageQueue")
    public void listenMessages(String message) {
        log.info("Received message from ActiveMQ: " + message);
    }
}
