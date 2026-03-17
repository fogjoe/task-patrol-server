package com.example.shadow.web;

import com.example.shadow.common.core.Result;
import com.example.shadow.common.exception.BusinessException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// @RestControllerAdvice = @ControllerAdvice + @ResponseBody
// 这个类是所有 Controller 的“保姆”，专门处理它们抛出的异常
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 1. Handle validation exceptions from DTOs (@Valid / @Validated)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleValidationException(MethodArgumentNotValidException e) {
        // Extract the default message defined in the DTO
        String errorMsg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return Result.error(errorMsg);
    }

    // 2. Handle custom business logic exceptions
    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusinessException(BusinessException e) {
        return Result.error(e.getMessage());
    }

    // 3. Fallback handler for all other unexpected runtime exceptions
    @ExceptionHandler(RuntimeException.class)
    public Result<?> handleRuntimeException(RuntimeException e) {
        e.printStackTrace(); // Print stack trace to console for debugging
        return Result.error("System error: " + e.getMessage());
    }
}