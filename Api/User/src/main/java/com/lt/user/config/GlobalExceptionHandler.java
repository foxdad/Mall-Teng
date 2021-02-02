package com.lt.user.config;

import com.lt.common.Result;
import com.lt.common.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/3 0:27
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Validated抛出的参数验证异常，如果使用aop拦截controller打印日志，这个异常不会进入到aop中
     * @param exception MethodArgumentNotValidException
     * @return 参数验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        return new Result<>().tipMessage(ResultEnum.FiledParameter.getCode(),  Optional.ofNullable(exception.getBindingResult().getFieldError()).map(FieldError::getDefaultMessage).orElse(""));
    }

    /**
     * Validated抛出的参数验证异常，会进入到aop中
     * @param exception ConstraintViolationException
     * @return 参数验证异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result constraintViolationException(ConstraintViolationException exception) {

        return new Result<>().tipMessage(ResultEnum.FiledParameter.getCode(), exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining()));
    }
}
