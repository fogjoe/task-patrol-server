package com.example.shadow.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// @RestControllerAdvice = @ControllerAdvice + @ResponseBody
// 这个类是所有 Controller 的“保姆”，专门处理它们抛出的异常
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 拦截所有 RuntimeException（运行时异常）
    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> handleRuntimeException(RuntimeException e) {
        e.printStackTrace(); // 打印报错堆栈到控制台

        // 构造返回给前端的“标准”数据
        Map<String, Object> result = new HashMap<>();
        result.put("code", 500);
        result.put("msg", "The server has something error: " + e.getMessage()); // 生产环境通常不把详细错误给前端

        return  result;
    }
}