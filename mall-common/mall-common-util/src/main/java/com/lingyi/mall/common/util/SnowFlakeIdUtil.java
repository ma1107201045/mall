package com.lingyi.mall.common.util;

import cn.hutool.core.lang.Singleton;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.constant.BaseConstant;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/04/30 0:58
 * @description
 */
public final class SnowFlakeIdUtil {

    private SnowFlakeIdUtil() {
    }

    public static String nextStr() {
        return nextStr(getWorkerId(), BaseConstant.DATACENTER_ID);
    }

    public static String nextStr(long workerId) {
        return nextStr(workerId, BaseConstant.DATACENTER_ID);
    }

    public static String nextStr(long workerId, long datacenterId) {
        return String.valueOf(nextId(workerId, datacenterId));
    }

    public static long nextId() {
        return nextId(getWorkerId(), BaseConstant.DATACENTER_ID);
    }

    public static long nextId(long workerId) {
        return nextId(workerId, BaseConstant.DATACENTER_ID);
    }

    public static long nextId(long workerId, long datacenterId) {
        return Singleton.get(Snowflake.class, workerId, datacenterId).nextId();
    }


    private static long getWorkerId() {
        String localhostStr = NetUtil.getLocalhostStr();
        if (!NetUtil.isInnerIP(localhostStr)) {
            return BaseConstant.WORKER_ID;
        }
        return Arrays.stream(localhostStr.split(BaseConstant.POINT_DELIMITER)).mapToLong(Long::parseLong).sum();
    }


    private static String getBinaryStr(long value) {
        String str = StrUtil.fillBefore(NumberUtil.getBinaryStr(value), '0', 64);
        System.out.println(str.length());
        return str.charAt(0) + " - " + str.substring(1, 42) + " - " + str.substring(42, 47) + " " + str.substring(47, 57) + " - " + str.substring(57);
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.of(2023, 5, 1, 0, 0, 0, 0).toEpochSecond(ZoneOffset.of("+8")));
        System.out.println(LocalDateTime.of(2023, 5, 1, 0, 0, 0, 0).toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(nextId());
        System.out.println(getBinaryStr(nextId()));
        System.out.println(getBinaryStr(2479464776777472L));
        System.out.println(getBinaryStr(2479464877440768L));
    }


}
