package com.lingyi.mall.api.system.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.system.dto.UserDTO;
import com.lingyi.mall.api.system.dto.UserPartDTO;
import com.lingyi.mall.api.system.feign.UserFeign;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.vo.UserVO;

import com.lingyi.mall.common.base.util.ServerResponse;
import com.lingyi.mall.common.base.exception.OpenFeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class UserFeignConsumer {

    private final UserFeign userFeign;

    public void updatePartById(Long id, UserPartDTO userPartDTO) {
        log.info("入参:userPartDTO:{}", userPartDTO);
        ServerResponse<Void> response = userFeign.updatePartById(id, userPartDTO);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }

    public UserVO getUserAndMenuPermissionsByUserName(String userName) {
        log.info("入参:userName:{}", userName);
        ServerResponse<UserVO> response = userFeign.getUserAndMenuPermissionsByUserName(userName);
        if (response.getIsSuccess()) {
            log.info("出参:UserVO:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }

    public List<MenuVO> getMenuTreeByUserName(String userName) {
        log.info("入参:userName:{}", userName);
        ServerResponse<List<MenuVO>> response = userFeign.getMenuTreeByUserName(userName);
        if (response.getIsSuccess()) {
            log.info("出参:UserVO:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }
}
