package com.pedro.desafio.services;
import com.pedro.desafio.exceptions.InvalidTaskException;
import com.pedro.desafio.exceptions.NotFoundException;
import com.pedro.desafio.modules.TaskList;
import com.pedro.desafio.modules.dtos.TaskDTO;
import com.pedro.desafio.repositories.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository taskListRepository;

    public TaskList createList(TaskList list) {
        return taskListRepository.save(list);
    }

    public List<TaskList> getAllLists() {
        return taskListRepository.findAll();
    }

    public TaskList updateList(TaskList list) {
        taskListRepository.findById(list.getId())
                .orElseThrow(() -> new NotFoundException("TaskList not found with ID: " + list.getId()));


        return taskListRepository.save(list);
    }

    public Optional<TaskList> findById(Long id){
        return taskListRepository.findById(id)
                .or(() -> {
                    throw new NotFoundException("TaskList not found with ID: " + id);
                });
    }

    public void deleteList(Long listId) {
        taskListRepository.findById(listId)
                .orElseThrow(() -> new NotFoundException("TaskList not found with ID: " + listId));

        taskListRepository.deleteById(listId);
    }

    private void validateTaskList(TaskList taskList) {
        if (taskList.getName() == null || taskList.getName().length() <= 3) {
            throw new InvalidTaskException("TaskList name must have at least 3 characters.");
        }
    }
}
