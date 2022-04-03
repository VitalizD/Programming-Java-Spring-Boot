package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tasks")
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskNum;

    @Column(name = "list_num")
    private int listNum;

    @Column(name = "description")
    private String description;

    public Task(Integer listNum, String description) {
        this.description = description;
        this.listNum = listNum;
    }
}