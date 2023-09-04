package com.borges.Rotininha.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private boolean isCompleted;
    @ManyToOne
    @JoinColumn(referencedColumnName = "routine_id")
    private Routine routine;




}
