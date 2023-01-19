package com.example.todo.tasks;

import com.example.todo.common.ErrorResponseDto;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    ResponseEntity<List<TaskDto>> getAllTask() {
        var tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("")
    ResponseEntity<TaskDto> createNewTask(@RequestBody TaskDto taskDto) {
        var savedTask = taskService.createNewTask(taskDto);
        return ResponseEntity.created(URI.create("/task" + savedTask.getId())).body(savedTask);
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        var task = taskService.getTaskId(id);
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    void updateTaskById() {
    }

    @ExceptionHandler({
            TaskService.TaskNotFoundxception.class,
            TaskService.TaskAlreadyExistsException.class,
            TaskService.TaskInvalidException.class,
    })
    ResponseEntity<ErrorResponseDto> handleError(Exception e){
        if (e instanceof TaskService.TaskNotFoundxception){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(e.getMessage()));
        }
        if (e instanceof TaskService.TaskAlreadyExistsException){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ErrorResponseDto(e.getMessage()));
        }
        if (e instanceof TaskService.TaskInvalidException){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponseDto(e.getMessage()));

        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponseDto(e.getMessage()));

    }
}
