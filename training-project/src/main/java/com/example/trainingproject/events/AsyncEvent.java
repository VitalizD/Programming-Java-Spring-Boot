package com.example.trainingproject.events;

import org.springframework.context.ApplicationEvent;

public class AsyncEvent extends ApplicationEvent {
    public AsyncEvent(Object source) {
        super(source);
        System.out.println("Async event was created: " + this.hashCode());
    }
}
