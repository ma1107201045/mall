package com.lingyi.mall.api.system.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 16:25
 * @description
 */
@Data
public class MbsMenuVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7753690884211490825L;

    private Long menuId;
    
    private String permission;
}
