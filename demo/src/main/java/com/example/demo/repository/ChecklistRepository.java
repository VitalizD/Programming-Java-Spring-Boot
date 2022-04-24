package com.example.demo.repository;

import com.example.demo.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<Checklist, Integer> {
    Checklist findChecklistByName(String name);
}
