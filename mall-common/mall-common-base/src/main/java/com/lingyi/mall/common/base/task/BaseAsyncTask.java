package com.lingyi.mall.common.base.task;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.lingyi.mall.common.base.constant.TaskConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * TODO 待优化（由于maven存在循环依赖，暂且只能通过反射调用类）
 *
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 20:38
 * @Description:
 */
@Component
@RequiredArgsConstructor
public class BaseAsyncTask {


    @Async
    public void saveLog(Object logEntity) {
        Object logFeignConsumer = SpringUtil.getBean(TaskConstant.LOG_BEAN_NAME);
        ReflectUtil.invoke(logFeignConsumer, TaskConstant.LOG_METHOD_NAME, logEntity);
    }
}
