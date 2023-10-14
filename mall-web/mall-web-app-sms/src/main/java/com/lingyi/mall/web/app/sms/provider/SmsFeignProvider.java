package com.lingyi.mall.web.app.sms.provider;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.api.sms.feign.SmsFeign;
import com.lingyi.mall.biz.sms.service.SmsService;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:18
 * @description
 */
@Tag(name = "验证码", description = "验证码")
@Slf4j
@RequiredArgsConstructor
@RestController
public class SmsFeignProvider implements SmsFeign {

    private final SmsService smsService;

    @Operation(summary = "发送", description = "发送")
    @Override
    public ServerResponse<Void> send(SmsReqDTO smsReqDTO) {
        smsService.send(smsReqDTO);
        return ServerResponse.success();
    }


}
