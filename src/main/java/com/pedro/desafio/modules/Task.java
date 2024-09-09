package com.pedro.desafio.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedro.desafio.modules.dtos.TaskDTO;
import com.pedro.desafio.modules.enums.Priority;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column()
    private String title;
    @Column()
    private boolean completed = false;
    @Column()
    private boolean highlighted = false;

    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.MEDIUM;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;

    public Task() {
    }

    public Task(Long id, String title, boolean completed, boolean highlighted, Priority priority, TaskList taskList) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.highlighted = highlighted;
        this.priority = priority;
        this.taskList = taskList;
    }

    public Task(TaskDTO taskDTO) {
        this.id = taskDTO.getId();
        this.title = taskDTO.getTitle();
        this.priority = Priority.fromInt(taskDTO.getPriority());
        this.completed = taskDTO.isCompleted();
        this.highlighted = taskDTO.isHighlighted();
    }

}
