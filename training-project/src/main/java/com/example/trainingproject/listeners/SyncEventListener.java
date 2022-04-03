package com.example.trainingproject.listeners;

import com.example.trainingproject.events.SyncEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SyncEventListener {
    @EventListener
    public void listenMessageEvent(SyncEvent event) {
        System.out.println("Sync event has been processed: " + event.hashCode() +
                ". Thread: " + Thread.currentThread().getName());
    }
}
