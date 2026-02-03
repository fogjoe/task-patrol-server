package com.example.shadow.biz.service;

import com.example.shadow.biz.domain.TaskDo;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    Long createTask(String title, LocalDateTime deadline);
    List<TaskDo> findAllTasks();
}