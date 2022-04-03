package com.example.demo.service;

import com.example.demo.dto.ToDoIOFormat;
import com.example.demo.model.Checklist;
import com.example.demo.model.Task;
import com.example.demo.repositories.ChecklistRepository;
import com.example.demo.repositories.TaskRepository;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@ConstructorBinding
public class ToDoListService {
    private final ChecklistRepository checklistRepository;
    private final TaskRepository taskRepository;

    public ToDoListService(ChecklistRepository checklistRepository, TaskRepository taskRepository) {
        this.checklistRepository = checklistRepository;
        this.taskRepository = taskRepository;
    }

    public void saveChecklist(ToDoIOFormat toDoIOFormat) {
        var checklist = checklistRepository.save(new Checklist(toDoIOFormat.getName()));
        toDoIOFormat.getEvents().forEach(description -> {
            taskRepository.save(new Task(checklist.getListNum(), description));
        });
    }

    public ArrayList<ToDoIOFormat> getAllChecklistsWithAllTasks() {
        var result = new ArrayList<ToDoIOFormat>();
        var checklists = getAllChecklists();
        checklists.forEach(checklist -> {
            result.add(new ToDoIOFormat(checklist.getName(), getAllTaskDescriptionsFromChecklist(checklist)));
        });
        return result;
    }

    @Transactional
    public void deleteChecklistByName(String name) {
        var checklist = getChecklistByName(name);
        deleteAllTasksByListNum(checklist.getListNum());
        deleteChecklist(checklist);
    }

    private ArrayList<String> getAllTaskDescriptionsFromChecklist(Checklist checklist) {
        var taskDescriptions = new ArrayList<String>();
        getAllTasksFromChecklist(checklist).forEach(task -> taskDescriptions.add(task.getDescription()));
        return taskDescriptions;
    }

    private List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }

    private ArrayList<Task> getAllTasksFromChecklist(Checklist checklist) {
        return taskRepository.findAllByListNum(checklist.getListNum());
    }

    private Checklist getChecklistByName(String name) {
        return checklistRepository.findChecklistByName(name);
    }

    private void deleteAllTasksByListNum(Integer listNum) {
        taskRepository.deleteAllByListNum(listNum);
    }

    private void deleteChecklist(Checklist checklist) {
        checklistRepository.delete(checklist);
    }
}
