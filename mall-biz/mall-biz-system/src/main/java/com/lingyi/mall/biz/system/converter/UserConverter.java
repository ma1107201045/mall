package com.lingyi.mall.biz.system.converter;

import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.biz.system.entity.*;

/**
 * @Author maweiyan
 * @Email 1107201045@qq.com
 * @DateTime 2023/8/26 10:25
 * @Description
 */
public final class UserConverter {

    public static final UserConverter INSTANCE = new UserConverter();

    private UserConverter() {

    }

    public void convert(UserDO userDO, UserPartReqDTO userPartReqDTO) {
        userDO.setNickname(userPartReqDTO.getNickname());
        userDO.setPassword(userPartReqDTO.getPassword());
    }


}
