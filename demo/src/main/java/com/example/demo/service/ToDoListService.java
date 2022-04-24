package com.example.demo.service;

import com.example.demo.dto.ToDoIOFormat;
import com.example.demo.model.Checklist;
import com.example.demo.model.Task;
import com.example.demo.repository.ChecklistRepository;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@ConstructorBinding
public class ToDoListService {
    private final ChecklistRepository checklistRepository;

    public ToDoListService(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }

    public void saveChecklist(ToDoIOFormat toDoIOFormat) {
        var checklist = new Checklist(toDoIOFormat.getName());
        toDoIOFormat.getEvents().forEach(description -> { checklist.addTask(new Task(description)); });
        checklistRepository.save(checklist);
    }

    public List<ToDoIOFormat> findAll() {
        List<ToDoIOFormat> res = new ArrayList<>();
        var checklists = checklistRepository.findAll();
        checklists.forEach(checklist -> {
            List<String> tasks = new ArrayList<>();
            checklist.getTasks().forEach(task -> { tasks.add(task.getDescription()); });
            res.add(new ToDoIOFormat(checklist.getName(), tasks));
        });
        return res;
    }

    @Transactional
    public void deleteChecklist(String name) {
        var checklist = checklistRepository.findChecklistByName(name);
        checklistRepository.delete(checklist);
    }
}
