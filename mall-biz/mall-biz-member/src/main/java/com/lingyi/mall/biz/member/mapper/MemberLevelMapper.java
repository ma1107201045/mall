package com.lingyi.mall.biz.member.mapper;

import com.lingyi.mall.biz.member.param.MemberLevelParam;
import com.lingyi.mall.biz.member.vo.MemberLevelVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:33
 * @description
 */
@Mapper
public interface MemberLevelMapper {

    MemberLevelVO selectById(Long id);

    List<MemberLevelVO> selectListByParam(MemberLevelParam memberLevelParam);

    Long selectIdByIsDefaultLevel(Integer isDefaultLevel);
}
