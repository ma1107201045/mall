
package com.lingyi.mall.api.system.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 21:32
 * @Description:
 */
@Data
public class MbsUserVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1243838317263367362L;

    private Long userId;

    private String password;

    private Integer isEnable;

    private List<MbsMenuVO> mbsMenuVOS;

}
