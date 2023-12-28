package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.api.member.reqeust.MemberLoginLogRequest;
import com.lingyi.mall.biz.member.model.dto.MemberLoginLogDTO;
import com.lingyi.mall.biz.member.model.entity.MemberLoginLogDO;
import com.lingyi.mall.biz.member.model.query.MemberLoginLogQuery;
import com.lingyi.mall.biz.member.model.vo.MemberLoginLogVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/6 9:22
 * @description
 */
public interface MemberLoginLogService extends BaseServicePro<MemberLoginLogDTO, MemberLoginLogVO, MemberLoginLogQuery, MemberLoginLogDO, Long> {


    /**
     * 保存会员登录日志
     *
     * @param memberLoginLogRequest 。。
     */
    void save(MemberLoginLogRequest memberLoginLogRequest);
}
