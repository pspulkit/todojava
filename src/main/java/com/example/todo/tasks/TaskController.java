package com.example.todo.tasks;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping("")
    ResponseEntity getAllTask(){
        var tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("")
    void createNewTask(@RequestBody TaskDto taskDto){

    }

    @GetMapping("/{id}")
    void getTaskById(){}

    @PatchMapping("/{id}")
    void updateTaskById(){}

}
