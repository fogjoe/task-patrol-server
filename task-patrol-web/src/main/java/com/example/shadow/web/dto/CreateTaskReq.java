package com.example.shadow.web.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreateTaskReq {
    private String title;
    private LocalDateTime deadline;
}