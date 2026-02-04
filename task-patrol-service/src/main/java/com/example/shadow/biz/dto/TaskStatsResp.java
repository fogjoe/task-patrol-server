package com.example.shadow.biz.dto;

import lombok.Data;

@Data
public class TaskStatsResp {
    // 1. 总任务数
    private Long totalCount;

    // 2. 未完成的任务数（status = 0）
    private Long todoCount;

    // 3. 已完成的任务数（status = 1）
    private Long doneCount;

    // 4. 所谓的“过期任务”ID列表，用逗号拼起来（例如“1001”，“1003”）
    private String expiredTaskIds;
}