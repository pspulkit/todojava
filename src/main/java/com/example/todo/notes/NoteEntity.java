package com.example.todo.notes;

import com.example.todo.common.BaseEntity;
import com.example.todo.tasks.TaskEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "notes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteEntity extends BaseEntity {
    @Column(name = "title",nullable = false,length = 1000)
    String title;
    @Column(name = "body",nullable = false,length = 1000)
    String body;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    TaskEntity task;
}
