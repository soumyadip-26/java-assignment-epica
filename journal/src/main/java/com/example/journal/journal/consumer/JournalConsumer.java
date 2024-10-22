package com.example.journal.journal.consumer;

import com.example.journal.journal.model.Journal;
import com.example.journal.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JournalConsumer {
    @Autowired
    private JournalRepository journalRepository;

    @KafkaListener(topics = "user-events", groupId = "journal_group")
    public void consumeUserEvent(String message) {
        Journal journal = new Journal();
        journal.setMessage(message);
        journalRepository.save(journal);
        System.out.println("Consumed message: " + message);
    }

}
