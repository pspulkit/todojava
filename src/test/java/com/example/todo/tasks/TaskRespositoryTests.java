package com.example.todo.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest

public class TaskRespositoryTests {
    @Autowired private TaskRespository taskRespository;

    @Test
    public void canCreateTask(){
        TaskEntity task = new TaskEntity();
        task.setName("test");
        task.setDueDate(new Date());
        task.setDone(true);
        taskRespository.save(task);

        assertEquals("test",taskRespository.findAll().get(0).getName());
    }
}
