package com.example.shadow.biz.service.impl;

import com.example.shadow.biz.domain.TaskDo;
import com.example.shadow.biz.dto.TaskStatsResp;
import com.example.shadow.biz.mapper.TaskMapper;
import com.example.shadow.biz.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public TaskStatsResp getStatistics() {
        // 1. 先把所有的数据查出来（模拟从数据库取全量数据）
        List<TaskDo> allTasks = taskMapper.selectList(null);
        TaskStatsResp resp = new TaskStatsResp();

        // === challenge 1: count totals
        resp.setTotalCount((long) allTasks.size());

        // === challenge 2: count undone totals
        long todo = allTasks.stream()
                .filter(t -> t.getStatus() == 0)
                .count();
        resp.setTodoCount(todo);

        // === challenge 3: count done totals
        long done = allTasks.stream()
                .filter(t -> t.getStatus() == 1)
                .count();
        resp.setDoneCount(done);

        // === challenge 4: find all expired and undone tasks, extract id and make up the string
        // status = 0 && deadline < now
        String expiredIds = allTasks.stream()
                .filter(t -> t.getStatus() == 0)
                .filter(t -> t.getDeadline() != null && t.getDeadline().isBefore(LocalDateTime.now()))
                .map(t -> t.getId().toString())
                .collect(Collectors.joining(","));
        resp.setExpiredTaskIds(expiredIds);

        return resp;
    }
}