package com.lingyi.mall.common.security.admin.propertis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 20:55
 * @Description: 验证码属性配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "image-captcha")
public class ImageCaptchaProperties {

    /**
     * 验证码存到session的属性名
     */
    private String sessionAttributeName = "imageCaptcha";

    /**
     * 验证码宽度
     */
    private int width = 120;
    /**
     * 验证码高度
     */
    private int height = 50;

    /**
     * 验证码个数
     */
    private int count = 4;

    /**
     * 验证码生成规则
     */
    private CodeGenerator codeGenerator = CodeGenerator.RANDOM;
    /**
     * 验证码干扰类型
     */
    private DisturbanceType disturbanceType = DisturbanceType.LINE;

    /**
     * 验证码干扰类型个数
     */
    private int typeCount = 10;

    public enum CodeGenerator {
        /**
         * 随机
         */
        RANDOM,
        /**
         * 数学
         */
        MATH;

    }

    public enum DisturbanceType {
        /**
         * 线干扰的验证码
         */
        LINE,
        /**
         * 圆圈干扰的验证码
         */
        CIRCLE,
        /**
         * 扭曲干扰的验证码
         */
        SHEAR,
        /**
         * GIF验证码
         */
        GIF;
    }
}
