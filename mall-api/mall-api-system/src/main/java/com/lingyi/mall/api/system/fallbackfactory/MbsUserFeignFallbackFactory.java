package com.lingyi.mall.api.system.fallbackfactory;

import com.lingyi.mall.api.system.feign.MbsUserFeign;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.common.base.util.ServerResponse;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:34
 * @Description:
 */
public class MbsUserFeignFallbackFactory implements FallbackFactory<MbsUserFeign> {

    @Override
    public MbsUserFeign create(Throwable cause) {
        return new MbsUserFeign() {
            @Override
            public ServerResponse<Void> updateLastLoginDateTimeById(Long id) {
                return null;
            }

            @Override
            public ServerResponse<UserVO> getUserAndMenuPermissionsByUserName(String userName) {
                return null;
            }

            @Override
            public ServerResponse<List<MenuVO>> getMenuTreeByUserName(String userName) {
                return null;
            }
        };
    }
}
