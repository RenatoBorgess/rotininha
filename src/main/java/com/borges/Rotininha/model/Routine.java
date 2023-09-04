package com.borges.Rotininha.model;

import com.borges.Rotininha.model.Task;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
@Entity
@Data
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "routine_id")
    private Long id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "routine")
    private ArrayList<Task> Tasks;
}
