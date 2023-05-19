package com.lingyi.mall.api.system.b.fallbackfactory;

import com.lingyi.mall.api.system.b.feign.MbsUserFeign;
import com.lingyi.mall.api.system.b.vo.MenuVO;
import com.lingyi.mall.api.system.b.vo.UserVO;
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
