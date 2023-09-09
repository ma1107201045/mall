package com.lingyi.mall.biz.sms.service.impl;

import com.lingyi.mall.biz.sms.entity.CaptchaLogDO;
import com.lingyi.mall.biz.sms.enums.SmsFailEnum;
import com.lingyi.mall.biz.sms.mapper.CaptchaLogMapper;
import com.lingyi.mall.biz.sms.param.CaptchaLogParam;
import com.lingyi.mall.biz.sms.repositroy.CaptchaLogRepository;
import com.lingyi.mall.biz.sms.service.CaptchaLogService;
import com.lingyi.mall.common.core.util.AssertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:19
 * @description
 */
@Service
@RequiredArgsConstructor
public class CaptchaLogServiceImpl implements CaptchaLogService {

    private final CaptchaLogRepository captchaLogRepository;

    private final CaptchaLogMapper captchaLogMapper;

    @Override
    public void create(CaptchaLogDO captchaLogDO) {
        captchaLogRepository.save(captchaLogDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        captchaLogRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(CaptchaLogDO captchaLogDO) {
        Long id = captchaLogDO.getId();
        //获取验证码日志信息
        var optional = captchaLogRepository.findById(id);
        //断言验证码日志是否不为空
        AssertUtil.isFalse(optional.isEmpty(), SmsFailEnum.CAPTCHA_LOG_NULL_ERROR);
        //获取用户
        var newCaptchaLogDO = optional.get();
        //更新验证码日志信息
        captchaLogRepository.save(newCaptchaLogDO);
    }

    @Override
    public CaptchaLogDO readById(Long id) {
        return null;
    }

    @Override
    public List<CaptchaLogDO> readListByParam(CaptchaLogParam param) {
        return null;
    }
}
