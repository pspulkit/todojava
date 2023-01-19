package com.example.todo.tasks;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {
    @Nullable
    Long id;
    @Nullable
    String name;
    @Nullable
    Date dueDate;
    @Nullable
    boolean done;
}
