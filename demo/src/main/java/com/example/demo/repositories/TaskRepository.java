package com.example.demo.repositories;

import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    ArrayList<Task> findAllByListNum(Integer id);
    void deleteAllByListNum(Integer id);
}
