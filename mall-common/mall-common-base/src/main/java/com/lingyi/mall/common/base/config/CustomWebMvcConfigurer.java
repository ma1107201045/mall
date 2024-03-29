package com.lingyi.mall.common.base.config;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Objects;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 20:30
 * @Description:
 */
@Component
@RequiredArgsConstructor
public class CustomWebMvcConfigurer implements WebMvcConfigurer {


    private final CustomAsyncConfigurer customAsyncConfigurer;

    @Override
    public void configureAsyncSupport(@NotNull AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(Objects.requireNonNull(customAsyncConfigurer.getAsyncExecutor()));
    }

    /**
     * 使用此方法, 以下 spring-boot: jackson时间格式化 配置 将会失效
     * spring.jackson.time-zone=GMT+8
     * spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
     * 原因: 会覆盖 @EnableAutoConfiguration 关于 WebMvcAutoConfiguration 的配置
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//
//        ObjectMapper objectMapper = mappingJackson2HttpMessageConverter.getObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        //TODO 日期反序列化问题
//        SimpleModule simpleModule = new SimpleModule();
//        //  LocalDateTime时间格式化
//        simpleModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(BaseConstant.DEFAULT_DATE_TIME_PATTERN)));
//        // LocalDate时间格式化
//        simpleModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(BaseConstant.DEFAULT_DATE_PATTERN)));
//        // LocalTime时间格式化
//        simpleModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(BaseConstant.DEFAULT_TIME_PATTERN)));
//        // 字符串转成LocalDateTime
//        simpleModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(BaseConstant.DEFAULT_DATE_TIME_PATTERN)));
//        // 字符串转成LocalDate
//        simpleModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(BaseConstant.DEFAULT_DATE_PATTERN)));
//        // 字符串转成LocalTime
//        simpleModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(BaseConstant.DEFAULT_TIME_PATTERN)));
//        objectMapper.registerModule(simpleModule);
//
//        objectMapper.setDateFormat(new SimpleDateFormat(BaseConstant.DEFAULT_DATE_TIME_PATTERN));
//
//        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
//
//        converters.add(0, mappingJackson2HttpMessageConverter);
//        //需要追加byte，否则springdoc-openapi接口会响应Base64编码内容，导致接口文档显示失败
//        // https://github.com/springdoc/springdoc-openapi/issues/2143
//        //解决方案
//        converters.add(1, new ByteArrayHttpMessageConverter());


    }
}
