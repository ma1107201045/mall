
package com.lingyi.mall.api.system.vo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.api.system.entity.MbsRole;
import com.lingyi.mall.api.system.entity.MbsUser;
import com.lingyi.mall.api.system.enums.MbsMenuType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 21:32
 * @Description: 获取用户信息以及对应的权限
 */
@Data
public class MbsUserVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1243838317263367362L;

    private String password;

    private Integer isEnabled;

    private List<String> permissions;


    public static MbsUserVO of(MbsUser mbsUser, List<MbsRole> mbsRoles) {
        MbsUserVO mbsUserVO = BeanUtil.copyProperties(mbsUser, MbsUserVO.class);
        List<String> permissions = new ArrayList<>();
        mbsRoles.forEach(mbsRole -> mbsRole.getMbsMenus().forEach(mbsMenu -> {
            if (MbsMenuType.MENU.getCode().equals(mbsMenu.getType())) {
                permissions.add(mbsMenu.getPermission());
            }
        }));
        mbsUserVO.setPermissions(permissions);
        return mbsUserVO;
    }
}
