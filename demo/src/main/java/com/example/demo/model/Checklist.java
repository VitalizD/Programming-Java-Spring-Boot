package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "checklists")
@NoArgsConstructor
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checklist", orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    public Checklist(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        tasks.add(task);
        task.setChecklist(this);
    }
}
