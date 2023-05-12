package com.lingyi.mall.api.system.consumer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.lingyi.mall.api.system.feign.MbsUserFeign;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.vo.UserVO;

import com.lingyi.mall.common.bean.util.ServerResponse;
import com.lingyi.mall.common.bean.exception.OpenFeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:41
 * @Description:
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MbsUserFeignConsumer {

    private final MbsUserFeign mbsUserFeign;

    public UserVO getUserAndMenuPermissionsByUserName(String userName) {
        log.info("入参:userName:{}", userName);
        ServerResponse<UserVO> response = mbsUserFeign.getUserAndMenuPermissionsByUserName(userName);
        if (response.getIsSuccess()) {
            log.info("出参:UserVO:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }

    public List<MenuVO> getMenuTreeByUserName(String userName) {
        log.info("入参:userName:{}", userName);
        ServerResponse<List<MenuVO>> response = mbsUserFeign.getMenuTreeByUserName(userName);
        if (response.getIsSuccess()) {
            log.info("出参:UserVO:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }
}
