package com.pedro.desafio.controllers;
import com.pedro.desafio.modules.Task;
import com.pedro.desafio.modules.dtos.TaskDTO;
import com.pedro.desafio.modules.dtos.TaskFilterDTO;
import com.pedro.desafio.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/list")
    public List<Task> filterTasks(@RequestBody TaskFilterDTO taskFilterDTO) {
        return taskService.filterTasks(taskFilterDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskDTO task) {
        task.setId(id);
        Task updatedTask = taskService.updateTask(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}

