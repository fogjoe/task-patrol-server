package com.example.shadow.biz.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("task")
public class TaskDo {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;
    private LocalDateTime deadline;
    private Integer status;
    private LocalDateTime createTime;
}