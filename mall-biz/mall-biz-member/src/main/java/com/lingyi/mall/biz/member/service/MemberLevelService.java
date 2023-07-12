package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.biz.member.entity.MemberLevelDO;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 9:14
 * @description
 */
public interface MemberLevelService {


    /**
     * 读取默认Id
     *
     * @param isDefaultLevel 是否是默认等级 1是 0否
     * @return id
     */
    MemberLevelDO readByIsDefaultLevel(Integer isDefaultLevel);
}
