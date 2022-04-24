package com.example.trainingproject.controller;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/active")
public class ActiveMQController {
    private final JmsTemplate jmsTemplate;

    public ActiveMQController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        jmsTemplate.convertAndSend("messageQueue", message);
        return "Success";
    }
}
