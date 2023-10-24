package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.api.member.dto.LoginLogReqDTO;
import com.lingyi.mall.biz.member.converter.MemberLoginConverter;
import com.lingyi.mall.biz.member.model.dto.LoginLogDTO;
import com.lingyi.mall.biz.member.model.entity.LoginLogDO;
import com.lingyi.mall.biz.member.model.param.LoginLogParam;
import com.lingyi.mall.biz.member.model.vo.LoginLogVO;
import com.lingyi.mall.biz.member.dao.mapper.LoginLogMapper;
import com.lingyi.mall.biz.member.dao.repository.LoginLogRepository;
import com.lingyi.mall.biz.member.service.LoginLogService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/6 9:23
 * @description
 */
@Service
public class LoginLogServiceImpl extends BaseServiceProImpl<LoginLogRepository, LoginLogMapper, LoginLogDTO, LoginLogVO, LoginLogParam, LoginLogDO, Long>
        implements LoginLogService {

    @Override
    public void save(LoginLogReqDTO loginLogReqDTO) {
        var memberLoginLogDO = MemberLoginConverter.INSTANCE.of(loginLogReqDTO);
        create(memberLoginLogDO);
    }
}
