package com.example.todo.common;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@MappedSuperclass

public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @CreatedDate
    Date createdAt;
    @UpdateTimestamp
    Date updatedAt;
}
