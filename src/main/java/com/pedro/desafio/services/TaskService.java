package com.pedro.desafio.services;
import com.pedro.desafio.exceptions.InvalidTaskException;
import com.pedro.desafio.exceptions.NotFoundException;
import com.pedro.desafio.modules.Task;
import com.pedro.desafio.modules.TaskList;
import com.pedro.desafio.modules.dtos.TaskDTO;
import com.pedro.desafio.modules.dtos.TaskFilterDTO;
import com.pedro.desafio.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskListService taskListService;

    public Task createTask(TaskDTO taskDTO) {
        TaskList taskList = taskListService.findById(taskDTO.getTaskListId())
                .orElseThrow();
        validateTask(taskDTO);
        Task task = new Task(taskDTO);
        task.setTaskList(taskList);


        return taskRepository.save(task);

    }

    public List<Task> filterTasks(TaskFilterDTO filterDTO) {
        if (filterDTO.getListId() != null) {
            taskListService.findById(filterDTO.getListId())
                    .orElseThrow(() -> new NotFoundException("TaskList not found with ID: " + filterDTO.getListId()));
        }
        return taskRepository.findByParameters(
                filterDTO.getListId(),
                filterDTO.getCompleted(),
                filterDTO.getHighlighted(),
                filterDTO.getPriority()
        );
    }

    public Task updateTask(TaskDTO taskDTO) {
        taskRepository.findById(taskDTO.getId())
                .orElseThrow(() -> new NotFoundException("Task not found with ID: " + taskDTO.getId()));
        TaskList taskList = taskListService.findById(taskDTO.getTaskListId())
                .orElseThrow(() -> new NotFoundException("TaskList not found with ID: " + taskDTO.getTaskListId()));

        validateTask(taskDTO);
        Task task = new Task(taskDTO);
        task.setTaskList(taskList);
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }


    private void validateTask(TaskDTO taskDTO) {
        if (taskDTO.getTitle() == null || taskDTO.getTitle().length() <= 3) {
            throw new InvalidTaskException("Task title must have at least 3 characters.");
        }
        if (taskDTO.getPriority() < 1 || taskDTO.getPriority() > 3) {
            throw new InvalidTaskException("Invalid task priority. Must be between 1 and 3.");
        }
    }

}
