package com.borges.Rotininha.service;

import com.borges.Rotininha.model.Task;
import com.borges.Rotininha.repository.TaskRepository;
import com.borges.Rotininha.dto.TaskDTO;
import com.borges.Rotininha.dto.TaskStatusDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task newTask = convertToEntity(taskDTO);
        Task savedTask = taskRepository.save(newTask);
        TaskDTO savedDTO = convertToDTO(savedTask);
        return savedDTO;

    }

    public TaskStatusDTO updateTaskStatus(Long id, TaskStatusDTO taskStatusDTO) {
        Optional<Task> taskOptional = taskRepository.findById(taskStatusDTO.id());
        if (taskOptional.isEmpty()) {
            throw new EntityNotFoundException("Task not found with ID: " + id);
        } else {
            Task existingTask = taskOptional.get();
            existingTask.setCompleted(taskStatusDTO.status());
            Task savedTask = taskRepository.save(existingTask);
            TaskStatusDTO statusDTO = new TaskStatusDTO(savedTask.getId(), savedTask.isCompleted());
            return statusDTO;
        }

    }
    public TaskDTO updateTask(Long id, TaskDTO task){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            throw new EntityNotFoundException("Task not found for the ID: " + id);
        } else {
            TaskDTO uptatedTask = convertToDTO(taskOptional.get());
            return uptatedTask;
        }
    }
    private TaskDTO convertToDTO(Task task){
        TaskDTO taskDTO = new TaskDTO(task.getId(),task.getTitle(),task.isCompleted(),task.getRoutine());
        return taskDTO;
    }
    private Task convertToEntity(TaskDTO taskDTO){
        Task task = new Task();
        task.setId(task.getId());
        task.setTitle(taskDTO.title());
        task.setCompleted(task.isCompleted());
        task.setRoutine(taskDTO.routine());
        return task;
    }
}