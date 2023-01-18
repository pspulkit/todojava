package com.example.todo.notes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest

public class NoteRespositoryTests {
    @Autowired private NoteRespository noteRespository;
    @Test
    public void createNote(){
        NoteEntity note = new NoteEntity();
        note.setTitle("testfortest");
        note.setBody("testtesttest");
        noteRespository.save(note);
        assertEquals("testfortest",noteRespository.findAll().get(0).getTitle());
    }


}
