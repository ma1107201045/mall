package com.lingyi.mall.biz.member.mapper;

import com.lingyi.mall.api.member.param.MemberParam;
import com.lingyi.mall.api.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:17
 * @description
 */
@Mapper
public interface MemberMapper {

    /**
     * 按照id查询
     *
     * @param id 主键id
     * @return MemberVO
     */
    MemberVO selectById(Long id);

    /**
     * 按照分页信息和条件查询
     *
     * @param memberParam 会员信息
     * @return List<UserVO>
     */
    List<MemberVO> selectListByParam(MemberParam memberParam);

    MemberVO selectByPhoneNumber(String phoneNumber);
}
