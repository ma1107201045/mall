package com.lingyi.mall.api.system.fallbackfactory;

import com.lingyi.mall.api.system.dto.MenuRespDTO;
import com.lingyi.mall.api.system.dto.UserRespDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
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
            public ServerResponse<Void> updatePartById(Long id, UserPartReqDTO userPartDTO) {
                return null;
            }

            @Override
            public ServerResponse<UserRespDTO> getUserAndMenuPermissionsByUserName(String userName) {
                return null;
            }

            @Override
            public ServerResponse<List<MenuRespDTO>> getMenuTreesByUserName(String userName) {
                return null;
            }


            @Override
            public ServerResponse<List<String>> getMenuPermissionsByUserName(String userName) {
                return null;
            }


        };
    }
}
