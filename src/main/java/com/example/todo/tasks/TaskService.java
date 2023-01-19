package com.example.todo.tasks;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
        var task  = taskRespository.findById(id).orElse(null);
        return modelMapper.map(task,TaskDto.class);
    }

    public TaskDto createNewTask(TaskDto task){
        var taskEntity = modelMapper.map(task,TaskEntity.class);
        var saveTask =  taskRespository.save(taskEntity);
        return modelMapper.map(saveTask,TaskDto.class);
    }

}
