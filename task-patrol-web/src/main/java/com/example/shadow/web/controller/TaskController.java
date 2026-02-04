package com.example.shadow.web.controller;

import com.example.shadow.biz.domain.TaskDo;
import com.example.shadow.biz.dto.TaskStatsResp;
import com.example.shadow.biz.service.TaskService;
import com.example.shadow.web.dto.CreateTaskReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 声明这是一个返回 JSON 的控制器
@RequestMapping("/tasks") // 所有接口前缀都是 /tasks
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService; // 注入 Service

    // POST /tasks
    @PostMapping
    public Long create(@RequestBody CreateTaskReq req) {
        // 调用 Service
        return taskService.createTask(req.getTitle(), req.getDeadline());
    }

    // GET /tasks
    @GetMapping
    public List<TaskDo> list() {
        return taskService.findAllTasks();
    }

    @GetMapping("/stats")
    public TaskStatsResp getStats() {
        return taskService.getStatistics();
    }
}