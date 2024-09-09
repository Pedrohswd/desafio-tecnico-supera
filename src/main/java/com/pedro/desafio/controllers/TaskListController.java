package com.pedro.desafio.controllers;
import com.pedro.desafio.modules.TaskList;
import com.pedro.desafio.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lists")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @GetMapping
    public List<TaskList> getAllLists() {
        return taskListService.getAllLists();
    }

    @PostMapping
    public ResponseEntity<TaskList> createList(@RequestBody TaskList list) {
        TaskList createdList = taskListService.createList(list);
        return ResponseEntity.ok(createdList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskList> updateList(@PathVariable Long id, @RequestBody TaskList list) {
        list.setId(id);
        TaskList updatedList = taskListService.updateList(list);
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
        taskListService.deleteList(id);
        return ResponseEntity.noContent().build();
    }
}
