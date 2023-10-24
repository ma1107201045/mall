package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.api.member.dto.LoginLogReqDTO;
import com.lingyi.mall.biz.member.model.dto.LoginLogDTO;
import com.lingyi.mall.biz.member.model.entity.MemberLoginLogDO;
import com.lingyi.mall.biz.member.model.param.LoginLogParam;
import com.lingyi.mall.biz.member.model.vo.LoginLogVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/6 9:22
 * @description
 */
public interface LoginLogService extends BaseServicePro<LoginLogDTO, LoginLogVO, LoginLogParam, MemberLoginLogDO, Long> {


    /**
     * 保存会员登录日志
     *
     * @param loginLogReqDTO 。。
     */
    void save(LoginLogReqDTO loginLogReqDTO);
}
