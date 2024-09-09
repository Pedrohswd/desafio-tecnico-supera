package com.pedro.desafio.repositories;
import com.pedro.desafio.modules.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM task t " +
            "WHERE " +
            "(:listId IS NULL OR t.task_list_id = :listId) " +
            "AND (:completed IS NULL OR t.completed = :completed) " +
            "AND (:highlighted IS NULL OR t.highlighted = :highlighted) " +
            "AND (:priority IS NULL OR t.priority = :priority) " +
            "ORDER BY t.priority ASC",
            nativeQuery = true)
    List<Task> findByParameters(
            @Param("listId") Long listId,
            @Param("completed") Boolean completed,
            @Param("highlighted") Boolean highlighted,
            @Param("priority") String priority);
}

