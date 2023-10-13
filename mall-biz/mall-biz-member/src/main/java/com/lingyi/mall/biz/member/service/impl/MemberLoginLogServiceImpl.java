package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.api.member.dto.MemberLoginLogReqDTO;
import com.lingyi.mall.biz.member.converter.MemberLoginConverter;
import com.lingyi.mall.biz.member.model.dto.MemberLoginLogDTO;
import com.lingyi.mall.biz.member.entity.MemberLoginLogDO;
import com.lingyi.mall.biz.member.model.param.MemberLoginParam;
import com.lingyi.mall.biz.member.model.vo.MemberLoginLogVO;
import com.lingyi.mall.biz.member.dao.mapper.MemberLoginLogMapper;
import com.lingyi.mall.biz.member.dao.repository.MemberLoginLogRepository;
import com.lingyi.mall.biz.member.service.MemberLoginLogService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/6 9:23
 * @description
 */
@Service
public class MemberLoginLogServiceImpl extends BaseServiceProImpl<MemberLoginLogRepository, MemberLoginLogMapper, MemberLoginLogDTO, MemberLoginLogVO, MemberLoginParam, MemberLoginLogDO, Long>
        implements MemberLoginLogService {

    @Override
    public void save(MemberLoginLogReqDTO memberLoginLogReqDTO) {
        var memberLoginLogDO = MemberLoginConverter.INSTANCE.of(memberLoginLogReqDTO);
        create(memberLoginLogDO);
    }
}
