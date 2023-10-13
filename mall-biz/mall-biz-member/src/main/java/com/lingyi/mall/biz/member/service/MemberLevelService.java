package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.biz.member.model.dto.MemberLevelDTO;
import com.lingyi.mall.biz.member.entity.MemberLevelDO;
import com.lingyi.mall.biz.member.model.param.MemberLevelParam;
import com.lingyi.mall.biz.member.model.vo.MemberLevelVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 9:14
 * @description
 */
public interface MemberLevelService extends BaseServicePro<MemberLevelDTO, MemberLevelVO, MemberLevelParam, MemberLevelDO, Long> {


    /**
     * 读取默认会员等级id
     */
    Long queryDefaultLevelId();
}
