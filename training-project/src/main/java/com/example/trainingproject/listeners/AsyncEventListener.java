package com.example.trainingproject.listeners;

import com.example.trainingproject.events.AsyncEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncEventListener {
    @Async
    @EventListener
    public void listenAsyncEvent(AsyncEvent event) {
        System.out.println("Async event has been processed: " + event.hashCode());
    }
}
