package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.api.member.dto.MemberLoginLogReqDTO;
import com.lingyi.mall.biz.member.converter.MemberLoginConverter;
import com.lingyi.mall.biz.member.dto.MemberLoginLogDTO;
import com.lingyi.mall.biz.member.entity.MemberDO;
import com.lingyi.mall.biz.member.entity.MemberLoginLogDO;
import com.lingyi.mall.biz.member.enums.MemberFailEnum;
import com.lingyi.mall.biz.member.param.MemberLoginParam;
import com.lingyi.mall.biz.member.vo.MemberLoginLogVO;
import com.lingyi.mall.biz.member.mapper.MemberLoginLogMapper;
import com.lingyi.mall.biz.member.repository.MemberLoginLogRepository;
import com.lingyi.mall.biz.member.service.MemberLoginLogService;
import com.lingyi.mall.common.core.exception.BizException;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        var memberLoginLogDTO = ConverterUtil.to(memberLoginLogReqDTO, MemberLoginLogDTO.class);
        var memberLoginLogDO = MemberLoginConverter.INSTANCE.of(memberLoginLogDTO);
        create(memberLoginLogDTO, memberLoginLogDO);
    }
}
