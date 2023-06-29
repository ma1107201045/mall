package com.lingyi.mall.common.security.admin.exception;

import org.springframework.security.core.AuthenticationException;

import java.io.Serial;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/29 10:22
 * @description
 */
public class ImageCaptchaException extends AuthenticationException {

    @Serial
    private static final long serialVersionUID = -4054098878253292452L;

    public ImageCaptchaException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ImageCaptchaException(String msg) {
        super(msg);
    }
}
