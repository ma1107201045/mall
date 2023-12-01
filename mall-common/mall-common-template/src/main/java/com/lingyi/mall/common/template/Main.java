package com.lingyi.mall.common.template;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

import java.io.StringWriter;
import java.util.Objects;
import java.util.Properties;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 10:53
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws Exception {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        String fileDir = Objects.requireNonNull(Main.class.getResource("/template/java/model")).getPath();
        Properties properties = new Properties();
        properties.setProperty(ve.FILE_RESOURCE_LOADER_PATH, fileDir);
        ve.init(properties);

        //        创建模板上下文对象
        VelocityContext context = new VelocityContext();
//        根据模板路径获得一个模板
//        默认路径是当前项目根目录
        Template template = Velocity.getTemplate("DO.java.vm", "utf-8");
//        给上下文添加数据，
        context.put("packageName", "com.lingyi.mall.biz");
        context.put("moduleName", "test");
        context.put("tableName", "t_test");
        context.put("className", "Test");
//        获取输出流
        StringWriter writer = new StringWriter();
//        将输出流和模板上下文合并
        template.merge(context, writer);
//        输出
        System.out.println(writer);

    }
}
