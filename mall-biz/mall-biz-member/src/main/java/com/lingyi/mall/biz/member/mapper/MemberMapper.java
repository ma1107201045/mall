package com.lingyi.mall.biz.member.mapper;

import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.biz.member.param.MemberParam;
import com.lingyi.mall.biz.member.vo.MemberVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:17
 * @description
 */
@Mapper
public interface MemberMapper extends MybatisMapperImplementation<Long, MemberParam, MemberVO> {

    /**
     * 按照手机号查询
     *
     * @param phoneNumber 手机号
     * @return MemberVO
     */
    MemberRespDTO selectByPhoneNumber(String phoneNumber);
}
