package com.example.todo.common;

import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorResponseDto {
    @NonNull
    private String message;
}
