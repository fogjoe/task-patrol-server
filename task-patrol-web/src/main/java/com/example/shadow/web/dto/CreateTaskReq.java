package com.example.shadow.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTaskReq {
    @NotBlank(message = "Title cannot be empty")
    @Size(min = 2, max = 50, message = "Title length must be between 2 and 50")
    private String title;

    @NotNull(message = "Deadline cannot be null")
    @Future(message = "Deadline must be a future time")
    private LocalDateTime deadline;
}