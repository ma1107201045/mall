package com.lingyi.mall.auth.app.service.impl;

import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.dto.AppRegisterDTO;
import com.lingyi.mall.auth.app.service.MaaAppService;
import com.lingyi.mall.auth.app.vo.AppLoginVO;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:50
 * @description
 */
@Service
public class MaaAppServiceImpl implements MaaAppService {
    @Override
    public AppLoginVO login(AppLoginDTO appLoginDTO) {

        return new AppLoginVO();

    }

    @Override
    public void register(AppRegisterDTO appRegisterDTO) {

    }

    @Override
    public void sendVerificationCode(String phoneNumber) {

    }
}
