package com.lingyi.mall.common.core.jackson.serializer;

import cn.hutool.core.util.DesensitizedUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/20 16:27
 * @Description:
 */
public class ChineseNameSerialize extends AbstractsJsonSerializer {
    @Override
    protected void doSerialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(DesensitizedUtil.chineseName(value));
    }
}
