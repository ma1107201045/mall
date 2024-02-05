package com.lingyi.mall.biz.system.converter.mapper;

import com.lingyi.mall.api.system.request.UserPartRequest;
import com.lingyi.mall.biz.system.model.entity.UserDO;
import org.mapstruct.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/2/5 9:03
 * @Description:
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDO toUserDO(UserPartRequest userPartRequest);
}
