package com.lingyi.mall.common.base.jpa.generator;

import com.lingyi.mall.common.base.entity.BaseIdEntity;
import com.lingyi.mall.common.base.util.SnowFlakeIdUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 14:47
 * @description
 */
@Component //可以不被spring容器所管理
public class SnowflakeIdentifierGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object obj) throws HibernateException {
        if (obj instanceof BaseIdEntity baseIdEntity) {
            return Objects.isNull(baseIdEntity.getId()) ? SnowFlakeIdUtil.nextId() : baseIdEntity.getId();
        }
        return SnowFlakeIdUtil.nextId();
    }
}
