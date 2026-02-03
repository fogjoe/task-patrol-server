package com.example.shadow.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shadow.biz.domain.TaskDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper extends BaseMapper<TaskDo> {
}
