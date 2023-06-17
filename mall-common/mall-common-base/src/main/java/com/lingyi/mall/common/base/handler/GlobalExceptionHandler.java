package com.lingyi.mall.common.base.handler;

import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.util.OpenFeignException;
import com.lingyi.mall.common.util.ServerResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Set;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/05/01 18:52
 * @description 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ServerResponse<String> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("HttpRequestMethodNotSupportedException：", e);
        return ServerResponse.fail(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServerResponse<Void> constraintViolationException(ConstraintViolationException e) {
        log.error("ConstraintViolationException：", e);
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        return ServerResponse.fail(HttpStatus.BAD_REQUEST.value(), constraintViolations.stream().map(ConstraintViolation::getMessage).toList().toString());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServerResponse<Void> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException：", e);
        List<ObjectError> objectErrors = e.getBindingResult().getAllErrors();
        return ServerResponse.fail(HttpStatus.BAD_REQUEST.value(), objectErrors.stream().map(ObjectError::getDefaultMessage).toList().toString());
    }

    @ExceptionHandler(value = MissingPathVariableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServerResponse<Void> missingPathVariableException(MissingPathVariableException e) {
        log.error("MissingPathVariableException：", e);
        return ServerResponse.fail(HttpStatus.BAD_REQUEST.value(), "请求路径参数" + e.getVariableName() + "不能为空");
    }


    @ExceptionHandler(value = MissingRequestHeaderException.class)
    public ServerResponse<Void> missingRequestHeaderException(MissingRequestHeaderException e) {
        log.error("MissingPathVariableException：{}", e.getMessage(), e);
        return ServerResponse.fail(HttpStatus.BAD_REQUEST.value(), "请求头参数" + e.getHeaderName() + "不能为空");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServerResponse<Void> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException：", e);
        return ServerResponse.fail(HttpStatus.BAD_REQUEST.value(), "请求体参数" + e.getParameterName() + "不能为空");
    }

    @ExceptionHandler(SocketTimeoutException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ServerResponse<Void> socketTimeoutException(SocketTimeoutException e) {
        log.error("SocketTimeoutException：", e);
        return ServerResponse.fail(HttpStatus.REQUEST_TIMEOUT.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    /**
     * 由于注解鉴权不走JsonAccessDeniedHandler，故只能全局配置
     *
     * @param exception 访问权限异常
     * @return ServerResponse<Void>
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ServerResponse<Void> accessDeniedException(AccessDeniedException exception) {
        log.error("AccessDeniedException：", exception);
        log.error("授权失败，错误原因:", exception);
        return ServerResponse.fail(HttpStatus.FORBIDDEN.value(), "不允许访问");
    }

    @ExceptionHandler(OpenFeignException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServerResponse<Void> openFeignException(OpenFeignException e) {
        log.error("OpenFeignException：", e);
        return ServerResponse.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServerResponse<Void> bizException(BizException e) {
        log.error("BizException：", e);
        return ServerResponse.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServerResponse<Void> runtimeException(RuntimeException re) {
        log.error("RuntimeException：", re);
        return ServerResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServerResponse<Void> exception(Exception e) {
        log.error("Exception：", e);
        return ServerResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServerResponse<Void> throwable(Throwable t) {
        log.error("Throwable", t);
        return ServerResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

}
