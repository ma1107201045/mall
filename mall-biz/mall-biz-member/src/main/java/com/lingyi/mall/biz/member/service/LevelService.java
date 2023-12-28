package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.biz.member.model.dto.LevelDTO;
import com.lingyi.mall.biz.member.model.entity.LevelDO;
import com.lingyi.mall.biz.member.model.query.LevelQuery;
import com.lingyi.mall.biz.member.model.vo.LevelVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 9:14
 * @description
 */
public interface LevelService extends BaseServicePro<LevelDTO, LevelVO, LevelQuery, LevelDO, Long> {


    /**
     * 读取默认会员等级id
     *
     * @return id
     */
    Long queryDefaultLevelId();
}
