package com.lingyi.mall.common.web.handler;

import cn.dev33.satoken.exception.DisableServiceException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.lingyi.mall.common.core.exception.BusinessException;
import com.lingyi.mall.common.core.exception.OpenFeignException;
import com.lingyi.mall.common.web.util.ServerResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.net.SocketTimeoutException;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/05/01 18:52
 * @description 全局异常处理器
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    private static final Integer PARAMETER_CODE = 1001;
    private static final Integer FILE_SIZE_CODE = 2001;

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    public ServerResponse<Void> constraintViolationException(ConstraintViolationException e) {
        log.error("ConstraintViolationException：", e);
        var constraintViolations = e.getConstraintViolations();
        return ServerResponse.fail(PARAMETER_CODE, constraintViolations
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList().toString());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ServerResponse<Void> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException：", e);
        var objectErrors = e.getBindingResult().getAllErrors();
        return ServerResponse.fail(PARAMETER_CODE, objectErrors.stream()
                .map(ObjectError::getDefaultMessage)
                .toList()
                .toString());
    }

    @ExceptionHandler(value = MissingRequestHeaderException.class)
    @ResponseStatus(HttpStatus.OK)
    public ServerResponse<Void> missingRequestHeaderException(MissingRequestHeaderException e) {
        log.error("MissingPathVariableException：{}", e.getMessage(), e);
        return ServerResponse.fail(PARAMETER_CODE, "请求头参数" + e.getHeaderName() + "不能为空");
    }

    @ExceptionHandler(value = MissingPathVariableException.class)
    @ResponseStatus(HttpStatus.OK)
    public ServerResponse<Void> missingPathVariableException(MissingPathVariableException e) {
        log.error("MissingPathVariableException：", e);
        return ServerResponse.fail(PARAMETER_CODE, "请求路径参数" + e.getVariableName() + "不能为空");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    public ServerResponse<Void> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException：", e);
        return ServerResponse.fail(PARAMETER_CODE, "请求体参数" + e.getParameterName() + "不能为空");
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.OK)
    public ServerResponse<Void> maxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        log.error("MaxUploadSizeExceededException：", e);
        return ServerResponse.fail(FILE_SIZE_CODE, String.format("上传文件超过最大值%dB", e.getMaxUploadSize()));
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public ServerResponse<Void> businessException(BusinessException e) {
        log.error("businessException：", e);
        return ServerResponse.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(OpenFeignException.class)
    @ResponseStatus(HttpStatus.OK)
    public ServerResponse<Void> openFeignException(OpenFeignException e) {
        log.error("OpenFeignException：", e);
        return ServerResponse.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ServerResponse<Void> notLoginException(NotLoginException exception) {
        log.error("notLoginException：", exception);
        log.error("暂未登录,错误原因:", exception);
        return ServerResponse.fail(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }

    @ExceptionHandler(DisableServiceException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ServerResponse<Void> disableServiceException(DisableServiceException exception) {
        log.error("disableServiceException：", exception);
        log.error("暂未登录,错误原因:", exception);
        return ServerResponse.fail(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }

    @ExceptionHandler(NotPermissionException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ServerResponse<Void> notLoginException(NotPermissionException exception) {
        log.error("notPermissionException：", exception);
        log.error("暂无权限,错误原因:", exception);
        return ServerResponse.fail(HttpStatus.FORBIDDEN.value(), exception.getMessage());
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ServerResponse<String> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("HttpRequestMethodNotSupportedException：", e);
        return ServerResponse.fail(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
    }


    @ExceptionHandler(SocketTimeoutException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ServerResponse<Void> socketTimeoutException(SocketTimeoutException e) {
        log.error("SocketTimeoutException：", e);
        return ServerResponse.fail(HttpStatus.REQUEST_TIMEOUT.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServerResponse<Void> runtimeException(RuntimeException e) {
        log.error("RuntimeException：", e);
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
