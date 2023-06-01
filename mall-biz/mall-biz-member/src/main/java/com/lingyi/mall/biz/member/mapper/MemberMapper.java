package com.lingyi.mall.biz.member.mapper;

import com.lingyi.mall.api.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:17
 * @description
 */
@Mapper
public interface MemberMapper {


    MemberVO selectByPhoneNumber(String phoneNumber);
}
