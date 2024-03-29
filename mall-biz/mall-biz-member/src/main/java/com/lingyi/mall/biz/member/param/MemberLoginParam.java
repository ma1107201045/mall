package com.lingyi.mall.biz.member.param;

import com.lingyi.mall.common.base.param.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/14 10:34
 * @description
 */
@Schema(description = "会员")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MemberLoginParam extends BasePageParam {
    @Serial
    private static final long serialVersionUID = -3145402049612960959L;
}
