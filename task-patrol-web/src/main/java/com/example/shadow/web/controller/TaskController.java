package com.example.shadow.web.controller;

import com.example.shadow.biz.domain.TaskDo;
import com.example.shadow.biz.dto.TaskStatsResp;
import com.example.shadow.biz.service.TaskService;
import com.example.shadow.web.annotation.LogExecutionTime;
import com.example.shadow.web.dto.CreateTaskReq;
import com.example.shadow.common.core.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 声明这是一个返回 JSON 的控制器
@RequestMapping("/tasks") // 所有接口前缀都是 /tasks
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService; // 注入 Service

    // POST /tasks
    @PostMapping
    public Result<Long> create(@Validated @RequestBody CreateTaskReq req) {
        if (req.getTitle().contains(("error"))) {
            throw new RuntimeException("find illegal strings!");
        }
        // 调用 Service
        Long id = taskService.createTask(req.getTitle(), req.getDeadline());
        return Result.success(id);
    }

    // GET /tasks
    @GetMapping
    @LogExecutionTime
    public Result<List<TaskDo>> list() {
        List<TaskDo> list = taskService.findAllTasks();
        return Result.success(list);
    }

    @GetMapping("/stats")
    public TaskStatsResp getStats() {
        return taskService.getStatistics();
    }

    @GetMapping("/{id}")
    public Result<TaskDo> getDetail(@PathVariable Long id) {
        TaskDo task = taskService.getTaskById(id);
        return Result.success(task);
    }
}