package com.lingyi.mall.biz.member.mapper;

import com.lingyi.mall.biz.member.param.MemberLevelParam;
import com.lingyi.mall.biz.member.vo.MemberLevelVO;
import com.lingyi.mall.common.jdbc.util.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:33
 * @description
 */
@Mapper
public interface MemberLevelMapper extends MybatisMapperImplementation<Long, MemberLevelParam, MemberLevelVO> {

    Long selectIdByIsDefaultLevel(Integer isDefaultLevel);
}
