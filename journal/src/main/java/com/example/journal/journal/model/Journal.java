package com.example.journal.journal.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "journals")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
}
