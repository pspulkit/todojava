package com.example.todo.tasks;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private TaskRespository taskRespository;
    private ModelMapper modelMapper;
    public TaskService(TaskRespository taskRespository,ModelMapper modelMapper){
        this.taskRespository = taskRespository;
        this.modelMapper = modelMapper;

    }
    public List<TaskDto> getAllTasks(){

        return taskRespository.findAll()
                .stream()
                .map(task -> modelMapper.map(task,TaskDto.class)
        ).collect(Collectors.toList());
    }

    public TaskDto getTaskId(Long id){
        var task  = taskRespository.findById(id).orElseThrow(() -> new TaskNotFoundxception(id));
        return modelMapper.map(task,TaskDto.class);
    }

    public TaskDto createNewTask(TaskDto task){
        if(task.getDueDate() != null && task.getDueDate().before(new Date())){
            throw new TaskInvalidException("due date must in the future");
        }
        var taskEntity = modelMapper.map(task,TaskEntity.class);
        var saveTask =  taskRespository.save(taskEntity);
        return modelMapper.map(saveTask,TaskDto.class);
    }

    static class TaskNotFoundxception extends IllegalArgumentException{
        public TaskNotFoundxception(Long id){
            super("task with id "+ id + "not found");
        }
    }

    static class TaskAlreadyExistsException extends IllegalArgumentException{
        public TaskAlreadyExistsException(Long id){
            super("task with id "+ id + "is already exists");
        }
    }

    static class TaskInvalidException extends IllegalArgumentException{
        public TaskInvalidException(String message){
            super(message);
        }
    }

}
