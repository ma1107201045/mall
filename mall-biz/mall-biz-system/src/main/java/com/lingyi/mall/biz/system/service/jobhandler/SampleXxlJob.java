package com.lingyi.mall.biz.system.service.jobhandler;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/9 14:43
 * @Description:
 */
public interface SampleXxlJob {


    void demoJobHandler() throws Exception;


    void shardingJobHandler() throws Exception;


    void commandJobHandler() throws Exception;

    void httpJobHandler() throws Exception;


    void demoJobHandler2() throws Exception;
}
