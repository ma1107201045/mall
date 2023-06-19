package com.lingyi.mall.api.system.fallbackfactory;

import com.lingyi.mall.api.system.dto.MenuResDTO;
import com.lingyi.mall.api.system.dto.UserResDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.api.system.feign.UserFeign;
import com.lingyi.mall.common.util.ServerResponse;
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
            public ServerResponse<Void> updatePartById(Long id, UserPartReqDTO userPartDTO) {
                return null;
            }

            @Override
            public ServerResponse<UserResDTO> getUserAndMenuPermissionsByUserName(String userName) {
                return null;
            }

            @Override
            public ServerResponse<List<MenuResDTO>> getMenuTreeByUserName(String userName) {
                return null;
            }

            @Override
            public ServerResponse<List<String>> getMenuPermissionsByUserIdAndUserName(Long userId, String userName) {
                return null;
            }
        };
    }
}
