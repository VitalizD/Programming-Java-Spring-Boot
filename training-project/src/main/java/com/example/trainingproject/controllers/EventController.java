package com.example.trainingproject.controllers;

import com.example.trainingproject.events.AsyncEvent;
import com.example.trainingproject.events.SyncEvent;
import com.example.trainingproject.events.TransactionEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EventController {
    private ApplicationEventPublisher publisher;

    public EventController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Transactional
    public void TriggerOnTransactionalEvent() {
        publisher.publishEvent(new TransactionEvent(this));
    }

    public void TriggerOnSyncEvent() {
        publisher.publishEvent(new SyncEvent(this));
    }

    public void TriggerOnAsyncEvent() {
        publisher.publishEvent(new AsyncEvent(this));
    }
}
