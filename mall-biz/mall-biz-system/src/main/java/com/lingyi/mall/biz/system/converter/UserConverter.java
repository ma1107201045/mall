package com.lingyi.mall.biz.system.converter;

import com.lingyi.mall.api.system.request.UserPartRequest;
import com.lingyi.mall.biz.system.model.entity.UserDO;
import org.apache.catalina.User;

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

    public UserDO to(UserPartRequest userPartRequest) {
        var userDO = new UserDO();
        userDO.setId(userPartRequest.getId());
        userDO.setNickname(userPartRequest.getNickname());
        userDO.setPassword(userPartRequest.getPassword());
        return userDO;
    }


}
