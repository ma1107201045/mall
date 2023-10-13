package com.lingyi.mall.biz.member.dao.mapper;

import com.lingyi.mall.biz.member.model.param.MemberLevelParam;
import com.lingyi.mall.biz.member.model.vo.MemberLevelVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:33
 * @description
 */
@Mapper
public interface MemberLevelMapper extends MybatisMapperImplementation<MemberLevelVO, MemberLevelParam, Long> {

    Long selectIdByIsDefaultLevel(Integer isDefaultLevel);
}