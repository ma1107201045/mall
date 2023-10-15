package com.lingyi.mall.biz.sms.dao.mapper;

import com.lingyi.mall.biz.sms.model.param.LogParam;
import com.lingyi.mall.biz.sms.model.vo.LogVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:17
 * @description
 */
@Mapper
public interface SmsLogMapper extends MybatisMapperImplementation<LogVO, LogParam, Long> {
}
