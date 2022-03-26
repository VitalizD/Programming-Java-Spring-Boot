package com.example.trainingproject.events;

import org.springframework.context.ApplicationEvent;

public class SyncEvent extends ApplicationEvent {
    public SyncEvent(Object source) {
        super(source);
        System.out.println("Sync event was created: " + this.hashCode());
    }
}

