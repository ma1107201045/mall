package com.lingyi.mall.common.core.jackson.serializer;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/20 16:28
 * @Description:
 */
public abstract class AbstractsJsonSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (StrUtil.isBlank(value)) {
            jsonGenerator.writeString(value);
            return;
        }
        doSerialize(value, jsonGenerator, serializerProvider);
    }

    protected abstract void doSerialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;
}
