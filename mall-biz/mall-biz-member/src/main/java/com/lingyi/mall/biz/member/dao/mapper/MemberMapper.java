package com.lingyi.mall.biz.member.dao.mapper;

import com.lingyi.mall.api.member.response.MemberResponse;
import com.lingyi.mall.biz.member.model.param.MemberParam;
import com.lingyi.mall.biz.member.model.vo.MemberVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:17
 * @description
 */
@Mapper
public interface MemberMapper extends MybatisMapperImplementation<MemberVO, MemberParam, Long> {

    /**
     * 按照手机号查询
     *
     * @param phoneNumber 手机号
     * @return MemberVO
     */
    MemberResponse selectByPhoneNumber(String phoneNumber);
}
