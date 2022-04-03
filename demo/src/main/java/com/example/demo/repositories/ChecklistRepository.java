package com.example.demo.repositories;

import com.example.demo.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ChecklistRepository extends JpaRepository<Checklist, Integer> {
    Checklist findChecklistByName(String name);
}
