package com.lingyi.mall.biz.member.dao.mapper;

import com.lingyi.mall.biz.member.model.param.LoginLogParam;
import com.lingyi.mall.biz.member.model.vo.LoginLogVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:40
 * @description
 */
@Mapper
public interface LoginLogMapper extends MybatisMapperImplementation<LoginLogVO, LoginLogParam, Long> {


}
