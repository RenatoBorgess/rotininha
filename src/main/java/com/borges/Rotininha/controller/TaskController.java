package com.borges.Rotininha.controller;

import com.borges.Rotininha.service.TaskService;
import com.borges.Rotininha.dto.TaskDTO;
import com.borges.Rotininha.dto.TaskStatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/tasks")

public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createTask(@RequestBody TaskDTO task){
        return taskService.createTask(task);
    }
    @PutMapping(path = "/status")
    public ResponseEntity<TaskStatusDTO> updateTaskStatus(Long id, @RequestBody TaskStatusDTO status){
    TaskStatusDTO updateTaskStatus = taskService.updateTaskStatus(id,status);
        return ResponseEntity.ok(updateTaskStatus);
    }
    @PutMapping
    public ResponseEntity<TaskDTO> updateTask(Long id, @RequestBody TaskDTO task){
        TaskDTO updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }
}
