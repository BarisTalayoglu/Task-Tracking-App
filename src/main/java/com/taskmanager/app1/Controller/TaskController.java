package com.taskmanager.app1.Controller;

import com.taskmanager.app1.Model.Task;
import com.taskmanager.app1.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam String description) {
        Task task = new Task();
        task.setDescription(description);
        taskService.addTask(task);
        return "redirect:/";
    }

    @PostMapping("/markAsCompleted")
    public String markAsCompleted(@RequestParam Long taskId) {
        taskService.markTaskAsCompleted(taskId);
        return "redirect:/";
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam Long taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/";
    }

    @PostMapping("/updateTaskDescription")
    public String updateTaskDescription(@RequestParam Long taskId, @RequestParam String newDescription) {
        taskService.updateTaskDescription(taskId, newDescription);
        return "redirect:/";
    }

    @GetMapping("/completedTasks")
    public String viewCompletedTasks(Model model) {
        List<Task> completedTasks = taskService.getCompletedTasks();
        model.addAttribute("tasks", completedTasks);
        return "completedTasks";
    }

    @GetMapping("/incompleteTasks")
    public String viewIncompleteTasks(Model model) {
        List<Task> incompleteTasks = taskService.getIncompleteTasks();
        model.addAttribute("tasks", incompleteTasks);
        return "incompleteTasks";
    }

}
