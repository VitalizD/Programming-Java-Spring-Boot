package com.example.trainingproject.listeners;

import com.example.trainingproject.events.TransactionEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class TransactionEventListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void listenMessageEventAfterCommit(TransactionEvent event) {
        System.out.println("Transactional event (after commit) has been processed: " + event.hashCode());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void listenMessageEventAfterRollback(TransactionEvent event) {
        System.out.println("Transactional event (after rollback) has been processed: " + event.hashCode());
    }
}
