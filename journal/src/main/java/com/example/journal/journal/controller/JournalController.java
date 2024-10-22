package com.example.journal.journal.controller;

import com.example.journal.journal.model.Journal;
import com.example.journal.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/journals")
public class JournalController {
    @Autowired
    private JournalRepository journalRepository;

    @GetMapping
    public ResponseEntity<List<Journal>> getAllJournals() {
        return ResponseEntity.ok(journalRepository.findAll());
    }
}
