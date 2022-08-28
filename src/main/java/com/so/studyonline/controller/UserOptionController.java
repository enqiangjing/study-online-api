package com.so.studyonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.so.studyonline.annotation.PassToken;
import com.so.studyonline.annotation.UserLoginToken;
import com.so.studyonline.config.ErrorCode;
import com.so.studyonline.enhance.ResMessage;
import com.so.studyonline.entity.SoUser;
import com.so.studyonline.exception.ExUserException;
import com.so.studyonline.service.SoUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class UserOptionController {

    private SoUserService soUserService;

    @Autowired
    public void setSoUserService(SoUserService soUserService) {
        this.soUserService = soUserService;
    }

    /**
     * 更新用户信息
     *
     * @param soUser 用户信息
     * @return 更新结果
     */
    @UserLoginToken
    @RequestMapping("api/userService/updateInfo")
    @ResponseBody
    public String updateInfo(@RequestBody SoUser soUser) {
        log.info("更新用户信息：{}", JSONObject.toJSONString(soUser));
        soUser.setPassword("");
        soUser.setUserRole("");
        return ResMessage.success(soUserService.updateOneUser(soUser));
    }

    /**
     * 更新用户密码
     *
     * @param request    请求报文
     * @param jsonObject 请求参数
     * @return 更新结果
     */
    @UserLoginToken
    @RequestMapping("api/userService/updatePassword")
    @ResponseBody
    public String updatePassword(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        String oldPass = jsonObject.getString("oldPass"); // 老密码
        String newPass = jsonObject.getString("newPass"); // 新密码
        String confirm = jsonObject.getString("confirm"); // 新密码
        if (!newPass.equals(confirm)) {
            throw new ExUserException(ErrorCode.USER_PASS_UP_ERROR);
        }
        String token = request.getHeader("Authorization"); // 从http请求头中取出 token(Authorization)
        String userNo = JWT.decode(token).getAudience().get(0);
        SoUser soUser = new SoUser();
        soUser.setUserNo(userNo);
        soUser.setPassword(oldPass);
        SoUser userFind = soUserService.findByUserInfo(soUser);  // 根据用户名和密码，查询数据库信息
        if (userFind == null) {
            throw new ExUserException(ErrorCode.USER_LOGIN_ERROR); // 未查到信息抛出异常
        }
        soUser.setPassword(newPass);
        return ResMessage.success(soUserService.updateOneUser(soUser));
    }

    /**
     * 查询用户信息
     *
     * @param soUser 查询条件
     * @return 单个用户
     */
    @PassToken
    @RequestMapping("api/userService/getUserInfoSimple")
    @ResponseBody
    public String getUserInfoSimple(@RequestBody SoUser soUser) {
        soUser=soUserService.findByUserInfo(soUser);
        soUser.setPassword("");
        soUser.setPhone("");
        soUser.setUserRole("");
        soUser.setEmail("");
        return ResMessage.success(soUser);
    }
}
