package com.lingyi.mall.biz.sms.dao.mapper;

import com.lingyi.mall.biz.sms.model.param.CaptchaLogParam;
import com.lingyi.mall.biz.sms.model.vo.CaptchaLogVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:17
 * @description
 */
@Mapper
public interface CaptchaLogMapper extends MybatisMapperImplementation<CaptchaLogVO, CaptchaLogParam, Long> {
}
