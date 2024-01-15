package com.lingyi.mall.auth.admin.converter;

import com.lingyi.mall.auth.admin.model.vo.ImageCaptchaVO;
/**
 * @Author maweiyan
 * @Email 1107201045@qq.com
 * @DateTime 2023/8/26 10:25
 * @Description
 */
public final class AuthAdminConverter {

    public static final AuthAdminConverter INSTANCE = new AuthAdminConverter();

    private AuthAdminConverter() {

    }

    public ImageCaptchaVO of(String uuid, String base64ImageCaptcha) {
        ImageCaptchaVO imageCaptchaVO = new ImageCaptchaVO();
        imageCaptchaVO.setUuid(uuid);
        imageCaptchaVO.setBase64ImageCaptcha(base64ImageCaptcha);
        return imageCaptchaVO;

    }


}
