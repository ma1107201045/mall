package com.lingyi.mall.biz.member.mapper;

import com.lingyi.mall.biz.member.param.MemberLevelParam;
import com.lingyi.mall.biz.member.param.MemberLoginParam;
import com.lingyi.mall.biz.member.vo.MemberLevelVO;
import com.lingyi.mall.biz.member.vo.MemberLoginLogVO;
import com.lingyi.mall.common.base.util.MybatisMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:40
 * @description
 */
@Mapper
public interface MemberLoginLogMapper extends MybatisMapper<Long, MemberLoginParam, MemberLoginLogVO> {


}
