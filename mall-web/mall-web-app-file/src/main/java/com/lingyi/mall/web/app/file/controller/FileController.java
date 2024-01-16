package com.lingyi.mall.web.app.file.controller;

import com.lingyi.mall.biz.file.enums.FileTypeEnum;
import com.lingyi.mall.biz.file.model.vo.FileVO;
import com.lingyi.mall.biz.file.service.FileService;
import com.lingyi.mall.biz.file.util.FileUtil;
import com.lingyi.mall.common.log.aspetct.annotation.Log;
import com.lingyi.mall.common.log.enums.ClientTypeEnum;
import com.lingyi.mall.common.orm.util.AuthenticatorUtil;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/20 14:26
 * @Description:
 */
@Tag(name = "文件接口", description = "文件接口")
@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;


    @Operation(summary = "上传", description = "保存")
    @Parameter(name = "file", description = "文件")
    @PostMapping
    public ServerResponse<FileVO> upload(MultipartFile file) throws IOException {
        var directoryName = FileUtil.getDirectoryName(ClientTypeEnum.ADMIN.toString(),
                AuthenticatorUtil.getCurrentUserName());
        var fileVO = fileService.upload(directoryName, file.getOriginalFilename(), file.getInputStream());
        return ServerResponse.success(fileVO);
    }

    @Operation(summary = "上传图片", description = "上传图片")
    @Parameter(name = "image", description = "图片")
    @PostMapping("/image")
    public ServerResponse<FileVO> uploadImage(MultipartFile image) throws IOException {
        var directoryName = FileUtil.getDirectoryName(ClientTypeEnum.ADMIN.toString(),
                AuthenticatorUtil.getCurrentUserName());
        var name = image.getOriginalFilename();
        var fileVO = fileService.upload(directoryName, name, FileTypeEnum.getContentTypeByFileName(name), image.getInputStream());
        return ServerResponse.success(fileVO);
    }

    @Operation(summary = "删除", description = "删除")
    @Parameter(name = "name", description = "名称")
    @DeleteMapping("/{name}")
    public ServerResponse<Void> delete(@PathVariable String name) {
        fileService.delete(name);
        return ServerResponse.success();
    }

}
