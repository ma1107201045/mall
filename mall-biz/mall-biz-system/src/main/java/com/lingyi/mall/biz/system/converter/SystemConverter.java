package com.lingyi.mall.biz.system.converter;

import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.biz.system.entity.UserDO;

/**
 * @Author maweiyan
 * @Email 1107201045@qq.com
 * @DateTime 2023/8/26 10:25
 * @Description
 */
public class SystemConverter {

    public static final SystemConverter INSTANCE = new SystemConverter();

    private SystemConverter() {

    }

    public UserDO to(UserDO userDO, UserPartReqDTO userPartReqDTO) {
        userDO.setNickname(userPartReqDTO.getNickname());
        userDO.setPassword(userPartReqDTO.getPassword());
        return userDO;
    }
}
