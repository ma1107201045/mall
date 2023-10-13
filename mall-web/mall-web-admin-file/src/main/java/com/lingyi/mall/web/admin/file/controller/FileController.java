package com.lingyi.mall.web.admin.file.controller;

import com.lingyi.mall.biz.file.enums.FileTypeEnum;
import com.lingyi.mall.biz.file.service.FileService;
import com.lingyi.mall.biz.file.util.FileUtil;
import com.lingyi.mall.biz.file.model.vo.FileVO;
import com.lingyi.mall.common.core.enums.ClientTypeEnum;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
import com.lingyi.mall.common.core.util.ServerResponse;
import com.lingyi.mall.security.admin.util.AuthenticatorUtil;
import com.lingyi.mall.common.core.annotation.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/27 22:55
 * @Description:
 */
@Tag(name = "文件接口", description = "文件接口")
@RequestMapping("/files")
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;


    @Operation(summary = "上传", description = "保存")
    @Parameter(name = "file", description = "文件")
    @PostMapping
    @Log(title = "上传文件", operationType = OperationTypeEnum.CREATE, ignoreParam = true)
    public ServerResponse<FileVO> upload(MultipartFile file) throws IOException {
        var directoryName = FileUtil.getDirectoryName(ClientTypeEnum.ADMIN, AuthenticatorUtil.getUserName());
        var fileVO = fileService.upload(directoryName, file.getOriginalFilename(), file.getInputStream());
        return ServerResponse.success(fileVO);
    }

    @Operation(summary = "删除", description = "删除")
    @Parameter(name = "name", description = "名称")
    @DeleteMapping("/{name}")
    @Log(title = "删除文件", operationType = OperationTypeEnum.DELETE)
    public ServerResponse<Void> delete(@PathVariable String name) {
        fileService.delete(name);
        return ServerResponse.success();
    }

    @Operation(summary = "上传图片", description = "上传图片")
    @Parameter(name = "file", description = "文件")
    @PostMapping("/image")
    @Log(title = "上传图片", operationType = OperationTypeEnum.CREATE, ignoreParam = true)
    public ServerResponse<FileVO> uploadImage(MultipartFile file) throws IOException {
        var directoryName = FileUtil.getDirectoryName(ClientTypeEnum.ADMIN, AuthenticatorUtil.getUserName());
        var name = file.getOriginalFilename();
        var fileVO = fileService.upload(directoryName, name, FileTypeEnum.getContentTypeByFileName(name), file.getInputStream());
        return ServerResponse.success(fileVO);
    }


}
