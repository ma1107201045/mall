package com.lingyi.mall.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author maiweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/05/01 18:52
 * @description
 */
@Getter
@RequiredArgsConstructor
public enum BaseResponseEnum {

    /**
     * 默认成功
     */
    SUCCESS(200, "成功"),
    /**
     * 默认失败
     */
    FAIL(500, "失败"),

    /**
     * 请求方法错误
     */
    REQUEST_METHOD_ERROR(501, "请求方法错误"),

    /**
     * 参数错误
     */
    PARAMETER_ERROR(502, "参数错误"),

    /**
     * 服务器连接超时
     */
    SERVER_CONNECT_TIMEOUT(503, "服务器连接超时"),

    /**
     * 服务器错误
     */
    SERVER_ERROR(504, "服务器错误"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(505, "未知错误");


    private final Integer code;


    private final String msg;
}
