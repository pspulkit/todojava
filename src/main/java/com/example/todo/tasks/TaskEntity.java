package com.example.todo.tasks;

import com.example.todo.common.BaseEntity;
import com.example.todo.notes.NoteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tasks")
public class TaskEntity extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "due_date",nullable = false)
    private Date dueDate;
    @Column(name = "status",nullable = false)
    Boolean done;
    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    List<NoteEntity> notes;

}
