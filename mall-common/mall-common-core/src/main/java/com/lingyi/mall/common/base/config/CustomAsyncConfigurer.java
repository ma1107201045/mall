package com.lingyi.mall.common.base.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.DefaultManagedAwareThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 20:22
 * @Description:
 */
@Component
public class CustomAsyncConfigurer implements AsyncConfigurer {

    private static final int MAX_SIZE = 500;
    private static final int QUEUE_SIZE = 500;
    private static final int KEEP_ALIVE_SECOND = 600;
    private static final int AWAIT_TERMINAL_SECOND = 60;
    private static final int CORE_SIZE = Runtime.getRuntime().availableProcessors() * 2;


    @Override
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setMaxPoolSize(MAX_SIZE);
        pool.setCorePoolSize(CORE_SIZE);
        pool.setQueueCapacity(QUEUE_SIZE);
        pool.setKeepAliveSeconds(KEEP_ALIVE_SECOND);
        pool.setAllowCoreThreadTimeOut(false);
        pool.setThreadFactory(new DefaultManagedAwareThreadFactory());
        /*
         *线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，
         *表示当线程池没有处理能力的时候，该策略会直接在execute方法的调用线程中运行这个任务；
         *如果执行程序已关闭，则会丢弃该任务
         */
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        pool.setThreadNamePrefix("async-aip-");
        // 该方法用来设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
        pool.setWaitForTasksToCompleteOnShutdown(true);
        pool.setAwaitTerminationSeconds(AWAIT_TERMINAL_SECOND);
        //初始化线程池
        pool.initialize();
        return pool;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
