package com.lingyi.mall.api.system.fallbackfactory;

import com.lingyi.mall.api.system.dto.MenuDTO;
import com.lingyi.mall.api.system.dto.UserDTO;
import com.lingyi.mall.api.system.dto.UserPartDTO;
import com.lingyi.mall.api.system.feign.UserFeign;
import com.lingyi.mall.common.base.util.ServerResponse;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:34
 * @Description:
 */
public class UserFeignFallbackFactory implements FallbackFactory<UserFeign> {

    @Override
    public UserFeign create(Throwable cause) {
        return new UserFeign() {


            @Override
            public ServerResponse<Void> updatePartById(Long id, UserPartDTO userPartDTO) {
                return null;
            }

            @Override
            public ServerResponse<UserDTO> getUserAndMenuPermissionsByUserName(String userName) {
                return null;
            }

            @Override
            public ServerResponse<List<MenuDTO>> getMenuTreeByUserName(String userName) {
                return null;
            }
        };
    }
}
