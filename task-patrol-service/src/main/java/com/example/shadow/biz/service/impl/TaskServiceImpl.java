package com.example.shadow.biz.service.impl;

import com.example.shadow.biz.domain.TaskDo;
import com.example.shadow.biz.mapper.TaskMapper;
import com.example.shadow.biz.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskMapper taskMapper;

    @Override
    public Long createTask(String title, LocalDateTime deadline) {
        TaskDo task = new TaskDo();
        task.setTitle(title);
        task.setDeadline(deadline);
        task.setStatus(0);
        task.setCreateTime(LocalDateTime.now());

        taskMapper.insert(task);
        return task.getId();
    }

    @Override
    public List<TaskDo> findAllTasks() {
        return taskMapper.selectList(null);
    }
}