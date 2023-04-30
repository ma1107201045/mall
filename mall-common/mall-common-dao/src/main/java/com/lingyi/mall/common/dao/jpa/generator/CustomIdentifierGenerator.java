package com.lingyi.mall.common.dao.jpa.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 14:47
 * @description
 */
public class CustomIdentifierGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return null;
    }
}
