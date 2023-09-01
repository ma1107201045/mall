package com.lingyi.mall.common.base.controller;

import com.lingyi.mall.common.base.util.ServerResponse;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/17 20:06
 * @Description:
 */
@Hidden
@RestController
@RequestMapping({"${server.error.path:${error.path:/error}}"})
public class BaseErrorController implements ErrorController {


    @RequestMapping
    public ServerResponse<Void> error(HttpServletRequest request) {
        var status = this.getStatus(request);
        return ServerResponse.fail(status.value(), status.getReasonPhrase());
    }


    protected HttpStatus getStatus(HttpServletRequest request) {
        var statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            try {
                return HttpStatus.valueOf(statusCode);
            } catch (Exception var4) {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }
    }

}
