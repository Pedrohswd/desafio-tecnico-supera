package com.pedro.desafio.modules.dtos;

import com.pedro.desafio.modules.Task;
import lombok.Data;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private boolean completed = false;
    private boolean highlighted = false;
    private int priority;
    private Long taskListId;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String title, boolean completed, boolean highlighted, int priority, Long taskListId) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.highlighted = highlighted;
        this.priority = priority;
        this.taskListId = taskListId;
    }

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.priority = task.getPriority().getLevel();
        this.completed = task.isCompleted();
        this.highlighted = task.isHighlighted();
        this.taskListId = task.getTaskList() != null ? task.getTaskList().getId() : null;
    }
}
