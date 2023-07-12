package com.lingyi.mall.biz.member.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:33
 * @description
 */
@Mapper
public interface MemberLevelMapper {


    Long selectIdByIsDefaultLevel(Integer isDefaultLevel);
}
