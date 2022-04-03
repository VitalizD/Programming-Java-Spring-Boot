package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoIOFormat {
    @NotEmpty(message = "Checklist name shouldn't be empty")
    @Size(max = 50, message = "Checklist name should be 50 characters maximum")
    private String name;

    @NotEmpty(message = "Task description shouldn't be empty")
    private ArrayList<@Valid String> events;
}
