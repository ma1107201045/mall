package com.lingyi.mall.common.bean.generator;

import cn.hutool.core.util.ObjUtil;
import com.lingyi.mall.common.bean.entity.BaseIdEntity;
import com.lingyi.mall.common.bean.util.SnowFlakeIdUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 14:47
 * @description
 */
@Component //可以不被spring容器所管理
public class SnowflakeIdentifierGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        if (o instanceof BaseIdEntity baseIdEntity) {
            return ObjUtil.isNull(baseIdEntity.getId()) ? SnowFlakeIdUtil.nextId() : baseIdEntity.getId();
        }
        return SnowFlakeIdUtil.nextId();
    }
}
