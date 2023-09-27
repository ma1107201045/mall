package com.lingyi.mall.auth.admin.properties;

import com.lingyi.mall.auth.admin.properties.enums.CodeGeneratorType;
import com.lingyi.mall.auth.admin.properties.enums.DisturbanceType;
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
     * 验证码生成器类型
     */
    private CodeGeneratorType codeGeneratorType = CodeGeneratorType.RANDOM;
    /**
     * 验证码干扰类型
     */
    private DisturbanceType disturbanceType = DisturbanceType.LINE;

    /**
     * 验证码干扰类型个数
     */
    private int typeCount = 10;

}
