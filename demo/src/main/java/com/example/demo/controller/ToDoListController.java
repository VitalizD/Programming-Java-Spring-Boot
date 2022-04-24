package com.example.demo.controller;

import com.example.demo.dto.ToDoIOFormat;
import com.example.demo.service.ToDoListService;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@ConstructorBinding
public class ToDoListController {
    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/new/checklist")
    public String add(@RequestBody @Valid ToDoIOFormat toDoInput) {
        toDoListService.saveChecklist(toDoInput);
        return "Saved";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody String checklistName) {
        toDoListService.deleteChecklist(checklistName);
        return "Deleted";
    }

    @GetMapping("/find/all")
    public List<ToDoIOFormat> getAll() {
        return toDoListService.findAll();
    }
}