package com.lingyi.mall.biz.member.mapper;

import com.lingyi.mall.biz.member.param.MemberLevelParam;
import com.lingyi.mall.biz.member.param.MemberParam;
import com.lingyi.mall.biz.member.vo.MemberLevelVO;
import com.lingyi.mall.biz.member.vo.MemberVO;
import com.lingyi.mall.common.base.util.MybatisMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:33
 * @description
 */
@Mapper
public interface MemberLevelMapper extends MybatisMapper<Long, MemberLevelParam, MemberLevelVO> {

    Long selectIdByIsDefaultLevel(Integer isDefaultLevel);
}
