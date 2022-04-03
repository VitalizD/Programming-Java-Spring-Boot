package com.example.demo.controllers;

import com.example.demo.dto.ToDoIOFormat;
import com.example.demo.service.ToDoListService;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Validated
@RestController
@ConstructorBinding
public class ToDoListController {
    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/new/checklist")
    public String add(@RequestBody @Valid ToDoIOFormat toDoInput, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors())
            return "Error";

        toDoListService.saveChecklist(toDoInput);
        return "Saved";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody String checklistName) {
        toDoListService.deleteChecklistByName(checklistName);
        return "Deleted";
    }

    @GetMapping("/find/all")
    public ArrayList<ToDoIOFormat> getAll() {
        return toDoListService.getAllChecklistsWithAllTasks();
    }
}