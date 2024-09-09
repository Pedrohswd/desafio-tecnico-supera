package com.pedro.desafio.repositories;

import com.pedro.desafio.modules.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
}
