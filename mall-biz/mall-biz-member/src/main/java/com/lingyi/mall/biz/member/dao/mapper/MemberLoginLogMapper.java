package com.lingyi.mall.biz.member.dao.mapper;

import com.lingyi.mall.biz.member.model.query.MemberLoginLogQuery;
import com.lingyi.mall.biz.member.model.vo.MemberLoginLogVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:40
 * @description
 */
@Mapper
public interface MemberLoginLogMapper extends MybatisMapperImplementation<MemberLoginLogVO, MemberLoginLogQuery, Long> {


}
