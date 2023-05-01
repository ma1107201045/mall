package com.lingyi.mall.common.web.handler;

import com.lingyi.mall.common.enums.BaseResponseEnum;
import com.lingyi.mall.common.exception.BizException;
import com.lingyi.mall.common.exception.OpenFeignException;
import com.lingyi.mall.common.util.ServerResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
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
    @ResponseStatus
    public ServerResponse<String> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("HttpRequestMethodNotSupportedException：{}", e.getMessage(), e);
        return ServerResponse.fail(BaseResponseEnum.REQUEST_METHOD_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ServerResponse<Void> paramsEx(ConstraintViolationException e) {
        log.error("ConstraintViolationException：{}", e.getMessage());
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        return ServerResponse.fail(BaseResponseEnum.PARAMETER_ERROR.getCode(), constraintViolations.stream()
                .map(ConstraintViolation::getMessage)
                .toList().toString());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ServerResponse<Void> paramsEx(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException：{}", e.getMessage());
        List<ObjectError> objectErrors = e.getBindingResult().getAllErrors();
        return ServerResponse.fail(BaseResponseEnum.PARAMETER_ERROR.getCode(), objectErrors.stream()
                .map(ObjectError::getDefaultMessage)
                .toList().toString());
    }

    @ExceptionHandler(value = MissingPathVariableException.class)
    public ServerResponse<Void> missHeaderEx(MissingPathVariableException e) {
        log.error("MissingPathVariableException：{}", e.getMessage(), e);
        return ServerResponse.fail(BaseResponseEnum.PARAMETER_ERROR.getCode(), "请求路径参数" + e.getVariableName() + "不能为空");
    }


//    @ExceptionHandler(value = MissingRequestHeaderException.class)
//    public ServerResponse<Void> missHeaderEx(MissingRequestHeaderException e) {
//        log.error("MissingRequestHeaderException：{}", e.getMessage(), e);
//        return ServerResponse.fail("请求头参数" + e.getHeaderName() + "不能为空");
//    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ServerResponse<Void> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException：{}", e.getMessage(), e);
        return ServerResponse.fail(BaseResponseEnum.PARAMETER_ERROR.getCode(), "请求体参数" + e.getParameterName() + "不能为空");
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public ServerResponse<Void> socketTimeoutException(SocketTimeoutException e) {
        log.error("SocketTimeoutException：{}", e.getMessage(), e);
        return ServerResponse.fail(BaseResponseEnum.SERVER_CONNECT_TIMEOUT);
    }


    @ExceptionHandler(OpenFeignException.class)
    public ServerResponse<Void> openFeignException(OpenFeignException e) {
        log.error("OpenFeignException：{}", e.getMessage(), e);
        return ServerResponse.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public ServerResponse<Void> bizException(BizException e) {
        log.error("BizException：{}", e.getMessage(), e);
        return ServerResponse.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ServerResponse<Void> runtimeException(RuntimeException re) {
        log.error("RuntimeException：{}", re.getMessage(), re);
        return ServerResponse.fail(BaseResponseEnum.SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ServerResponse<Void> exception(Exception e) {
        log.error("Exception：{}", e.getMessage(), e);
        return ServerResponse.fail(BaseResponseEnum.UNKNOWN_ERROR);
    }

    @ExceptionHandler(Throwable.class)
    public ServerResponse<Void> throwable(Throwable t) {
        log.error("Throwable：{}", t.getMessage(), t);
        return ServerResponse.fail(BaseResponseEnum.UNKNOWN_ERROR);
    }

}
