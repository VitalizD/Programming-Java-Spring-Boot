package com.example.trainingproject.events;

import org.springframework.context.ApplicationEvent;

public class TransactionEvent extends ApplicationEvent {

    public TransactionEvent(Object source) {
        super(source);
        System.out.println("Transition event was created: " + this.hashCode());
    }
}
