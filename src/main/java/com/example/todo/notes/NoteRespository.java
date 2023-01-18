package com.example.todo.notes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRespository extends JpaRepository<NoteEntity,Long> {
}
