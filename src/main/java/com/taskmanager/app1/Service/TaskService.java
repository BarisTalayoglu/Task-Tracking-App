package com.taskmanager.app1.Service;
import com.taskmanager.app1.Model.Task;
import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task addTask(Task task);
    void markTaskAsCompleted(Long taskId);
    void deleteTask(Long taskId);
    Task updateTaskDescription(Long taskId, String newDescription);
    List<Task> getCompletedTasks();
    List<Task> getIncompleteTasks();
}
