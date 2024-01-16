package com.lingyi.mall.api.system.fallbackfactory;

import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.api.system.request.UserPartRequest;
import com.lingyi.mall.api.system.feign.UserFeign;
import com.lingyi.mall.common.web.util.ServerResponse;
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
            public ServerResponse<Void> updatePartById(Long id, UserPartRequest userPartRequest) {
                return null;
            }

            @Override
            public ServerResponse<UserResponse> getUserByUserName(String userName) {
                return null;
            }

            @Override
            public ServerResponse<List<String>> getMenuPermissionsById(Long id) {
                return null;
            }

            @Override
            public ServerResponse<List<MenuResponse>> getMenuTreesById(Long id) {
                return null;
            }


        };
    }
}
