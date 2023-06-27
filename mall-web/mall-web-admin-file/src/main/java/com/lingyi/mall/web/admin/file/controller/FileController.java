package com.lingyi.mall.web.admin.file.controller;

import cn.hutool.core.io.FileUtil;
import com.lingyi.mall.biz.file.enums.ImageTypeEnum;
import com.lingyi.mall.biz.file.service.ImageFileService;
import com.lingyi.mall.common.base.aspect.Log;
import com.lingyi.mall.common.base.enums.OperationTypeEnum;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/27 22:55
 * @Description:
 */
@Tag(name = "【文件服务-文件】", description = "【系统管理服务-文件】")
@RequestMapping("/admin/file/files")
@RestController
@RequiredArgsConstructor
public class FileController {

    private final ImageFileService imageFileService;

    @Operation(summary = "上传", description = "保存")
    @PostMapping
    @Log(title = "上传文件", operationType = OperationTypeEnum.CREATE)
    public ServerResponse<String> upload(MultipartFile file) throws IOException {
        var url = imageFileService.upload(file.getOriginalFilename(), file.getInputStream());
        return ServerResponse.success(url);
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{name}")
    @Log(title = "删除文件", operationType = OperationTypeEnum.DELETE)
    public ServerResponse<Void> delete(@PathVariable String name) {
        imageFileService.delete(name);
        return ServerResponse.success();
    }

    @Operation(summary = "上传图片", description = "上传图片")
    @PostMapping("/image")
    @Log(title = "上传图片", operationType = OperationTypeEnum.CREATE)
    public ServerResponse<String> uploadImage(MultipartFile file) throws IOException {
        var name = file.getOriginalFilename();
        String url = imageFileService.upload(name, ImageTypeEnum.getContentTypeByFileName(FileUtil.extName(name)), file.getInputStream());
        return ServerResponse.success(url);
    }


}
