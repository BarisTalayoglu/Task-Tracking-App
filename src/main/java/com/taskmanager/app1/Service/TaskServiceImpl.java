package com.taskmanager.app1.Service;

import com.taskmanager.app1.Model.Task;
import com.taskmanager.app1.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void markTaskAsCompleted(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setCompleted(true);
            taskRepository.save(task);
        }
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task updateTaskDescription(Long taskId, String newDescription) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(newDescription);
            return taskRepository.save(task);
        }
        return null;
    }

    @Override
    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompleted(true);
    }

    @Override
    public List<Task> getIncompleteTasks() {
        return taskRepository.findByCompleted(false);
    }
}

