package com.lingyi.mall.common.orm.util;


import cn.hutool.core.lang.Singleton;
import cn.hutool.core.net.NetUtil;
import cn.hutool.setting.dialect.Props;
import cn.hutool.setting.dialect.PropsUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/04/30 0:58
 * @description
 */
@Slf4j
public final class SnowFlakeIdUtil {

    private static final String API_PROPERTIES_FILE_NAME = "api.properties";
    private static final String WORK_ID_KEY = "api.workerId";
    private static final String DATA_CENTER_ID_KEY = "api.dataCenterId";
    private static final long WORKER_ID = 0L;
    private static final long DATACENTER_ID = 0L;


    private SnowFlakeIdUtil() {
    }

    public static String nextStr() {
        return nextStr(getWorkerId(), getDataCenterId());
    }

    public static String nextStr(long workerId) {
        return nextStr(workerId, getDataCenterId());
    }

    public static String nextStr(long workerId, long datacenterId) {
        return String.valueOf(nextId(workerId, datacenterId));
    }

    public static long nextId() {
        return nextId(getWorkerId(), getDataCenterId());
    }

    public static long nextId(long workerId) {
        return nextId(workerId, getDataCenterId());
    }

    public static long nextId(long workerId, long datacenterId) {
        return Singleton.get(Snowflake.class, workerId, datacenterId).nextId();
    }


    public static long getWorkerId() {
        try {
            long[] params = getParams();
            return params[0];
        } catch (Exception e) {
            log.warn("api.properties not exist or error");
            var localhostStr = NetUtil.getLocalhostStr();
            if (!NetUtil.isInnerIP(localhostStr)) {
                return WORKER_ID;
            }
            return Arrays.stream(localhostStr.split(BaseConstant.POINT_CHAR_REGEX)).mapToLong(Long::parseLong).sum();
        }
    }

    public static long getDataCenterId() {
        try {
            long[] params = getParams();
            return params[1];
        } catch (Exception e) {
            log.warn("api.properties not exist or error");
            return DATACENTER_ID;
        }
    }


    private static long[] getParams() {
        long[] params = new long[2];
        Props props = PropsUtil.get(API_PROPERTIES_FILE_NAME);
        Enumeration<Object> keys = props.keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            if (key.equals(WORK_ID_KEY)) {
                params[0] = Long.parseLong((String) props.get(key));
            }
            if (key.equals(DATA_CENTER_ID_KEY)) {
                params[1] = Long.parseLong((String) props.get(key));
            }
        }
        return params;
    }

//    public static void main(String[] args) {
//        System.out.println(LocalDateTime.of(2023, 5, 1, 0, 0, 0, 0).toEpochSecond(ZoneOffset.of("+8")));
//        System.out.println(LocalDateTime.of(2023, 5, 1, 0, 0, 0, 0).toInstant(ZoneOffset.of("+8")).toEpochMilli());
//        System.out.println(nextId());
//        System.out.println(getBinaryStr(nextId()));
//        System.out.println(getBinaryStr(2479464776777472L));
//        System.out.println(getBinaryStr(2479464877440768L));
//    }
//
//    private static String getBinaryStr(long value) {
//        var str = StrUtil.fillBefore(NumberUtil.getBinaryStr(value), '0', 64);
//        System.out.println(str.length());
//        return str.charAt(0) + " - " + str.substring(1, 42) + " - " + str.substring(42, 47) + " " + str.substring(47, 57) + " - " + str.substring(57);
//    }

}
