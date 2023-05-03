package com.lingyi.mall.auth.background.service.Impl;

import com.lingyi.mall.auth.background.dto.UserAuthDTO;
import com.lingyi.mall.auth.background.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/2 12:56
 * @description
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    @Override
    public void login(UserAuthDTO userAuthDTO) {

    }

    @Override
    public void logout(HttpSession session) {

    }
}
