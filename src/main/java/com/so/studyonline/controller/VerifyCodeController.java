package com.so.studyonline.controller;

import com.so.studyonline.annotation.PassToken;
import com.so.studyonline.enhance.ResMessage;
import com.so.studyonline.service.VerifyCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class VerifyCodeController {
    private VerifyCodeService verifyCodeService;

    @Autowired
    public void setVerifyCodeService(VerifyCodeService verifyCodeService) {
        this.verifyCodeService = verifyCodeService;
    }

    /**
     * 获取验证码图片
     *
     * @param request 请求头
     * @return base64图片
     */
    @PassToken
    @RequestMapping("api/verifyCodeService/sendCodePicture")
    @ResponseBody
    public String sendCodePicture(HttpServletRequest request) {
        String time = String.valueOf(System.currentTimeMillis());
        String base64Img = verifyCodeService.createImg(request, time);
        return ResMessage.success(base64Img);
    }
}
