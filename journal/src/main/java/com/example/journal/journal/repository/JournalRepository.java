package com.example.journal.journal.repository;

import com.example.journal.journal.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {

}
