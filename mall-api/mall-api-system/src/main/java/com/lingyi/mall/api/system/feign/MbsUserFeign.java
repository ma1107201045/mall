package com.lingyi.mall.api.system.feign;

import com.lingyi.mall.api.system.fallbackfactory.MbsUserFeignFallbackFactory;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.common.util.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:34
 * @Description:
 */
@FeignClient(url = "http://localhost:9001", value = "mall-biz-system", fallbackFactory = MbsUserFeignFallbackFactory.class)
public interface MbsUserFeign {

    /**
     * 按照用户名称查询用户信息
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @GetMapping("/mbs/provider/users/menus")
    ServerResponse<UserVO> getUserAndMenuByUserName(@RequestParam(name = "userName") String userName);
}
