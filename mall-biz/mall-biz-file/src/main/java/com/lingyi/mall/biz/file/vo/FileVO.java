package com.lingyi.mall.biz.file.vo;

import cn.hutool.core.io.FileUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.util.ObjectUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/28 10:51
 * @description
 */
@Schema(description = "文件")
@Data
@Builder
public class FileVO {

    @Schema(description = "基础URL")
    private String baseUrl;

    @Schema(description = "相对URL")
    private String relativeUrl;

    @Schema(description = "绝对URL")
    private String url;

    @Schema(description = "原始名称")
    private String originalName;

    @Schema(description = "真实名称")
    private String actualName;

    public static FileVO of(String baseUrl, String url, String originalName) {
        String relativeUrl = null;
        String actualName = null;
        if (Objects.nonNull(baseUrl) && Objects.nonNull(url)) {
            relativeUrl = url.replaceAll(baseUrl, BaseConstant.EMPTY_CHAR);
        }
        if (Objects.nonNull(url)) {
            actualName = FileUtil.getName(url);
        }
        return FileVO.builder()
                .baseUrl(baseUrl)
                .relativeUrl(relativeUrl)
                .url(url)
                .originalName(originalName)
                .actualName(actualName)
                .build();
    }

    public static FileVO of(String url) {
        return of(ObjectUtil.getNull(), url, ObjectUtil.getNull());
    }
}
