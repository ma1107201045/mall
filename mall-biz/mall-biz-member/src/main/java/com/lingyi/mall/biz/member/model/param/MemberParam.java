package com.lingyi.mall.biz.member.model.param;

import com.lingyi.mall.common.core.param.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/2 15:53
 * @description
 */
@Schema(description = "会员参数")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MemberParam extends BasePageParam {

    @Schema(description = "用户名称")
    private String nickName;

}
