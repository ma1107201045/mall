package com.lingyi.mall.common.jdbc.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/9 9:42
 * @Description:
 */
@Data
public class BaseDTO<ID> implements Serializable {

    @Serial
    private static final long serialVersionUID = 3559017198770861533L;

    private ID id;
}
