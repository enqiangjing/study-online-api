package com.so.studyonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.so.studyonline.annotation.PassToken;
import com.so.studyonline.annotation.UserLoginToken;
import com.so.studyonline.config.ErrorCode;
import com.so.studyonline.enhance.RedisTemplate;
import com.so.studyonline.entity.SoConfig;
import com.so.studyonline.exception.ExSysException;
import com.so.studyonline.exception.ExUserException;
import com.so.studyonline.service.*;
import com.so.studyonline.entity.SoUser;
import com.so.studyonline.enhance.ResMessage;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class LoginController {

    private SoUserService soUserService;

    @Autowired
    public void setSoUserService(SoUserService soUserService) {
        this.soUserService = soUserService;
    }

    private TokenService tokenService;

    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    private SoConfigService soConfigService;

    @Autowired
    public void setSoConfigMapper(SoConfigService soConfigService) {
        this.soConfigService = soConfigService;
    }

    private VerifyCodeService verifyCodeService;

    @Autowired
    public void setVerifyCodeService(VerifyCodeService verifyCodeService) {
        this.verifyCodeService = verifyCodeService;
    }

    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Web 首页，模板引擎应用
     */
    @RequestMapping("/")
    public ModelAndView indexPage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("content", "api");
        mav.setViewName("/index.html");
        return mav;
    }

    /**
     * @param request  请求信息
     * @param response 响应信息
     * @return 返回结果值
     * @apiNote 登录入口
     */
    @PassToken
    @RequestMapping("api/loginService/submit")
    @ResponseBody
    public String submit(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject userLogin) {
        String userNo = userLogin.getString("userNo"); // 用户名
        String password = userLogin.getString("password"); // 密码
        String verifyCode = userLogin.getString("verifyCode"); // 验证码
        log.info("用户登录：{}", userNo);
        if (StringUtil.isNullOrEmpty(userNo) || StringUtil.isNullOrEmpty(password)) {
            throw new ExUserException(ErrorCode.USER_INFO_NULL); // 用户名和密码不能为空
        }
        SoConfig soConfig = new SoConfig();
        String appConfigVerifyCode = redisTemplate.get("app_config_verify_code");
        if (StringUtil.isNullOrEmpty(appConfigVerifyCode)) { // 获取验证码校验是否开启的标识
            log.info("未读取到 redis app_config_verify_code 配置，从数据库读取！");
            soConfig.setKey("verify_code");
            soConfig.setGroup("app_config");
            soConfig.setStatus("1");
            soConfig = soConfigService.getConfigItem(soConfig);
            redisTemplate.set5ks("app_config_verify_code", soConfig.getValue());
        } else {
            log.info("读取到 redis app_config_verify_code 配置 --- {}", appConfigVerifyCode);
            soConfig.setValue(appConfigVerifyCode);
        }
        String isOrNoVerifyCode = "N";
        if (!StringUtil.isNullOrEmpty(soConfig.getValue()) && soConfig.getValue().equals("Y")) {
            log.info("[LoginController] 已开启验证码校验！");
            isOrNoVerifyCode = "Y";
            if (StringUtil.isNullOrEmpty(verifyCode)) {
                throw new ExUserException(ErrorCode.USER_VERIFY_CODE_NULL); // 验证码不能为空
            }
            if (!verifyCodeService.verifyCodeCheck(request, verifyCode)) {
                throw new ExUserException(ErrorCode.VERIFY_CODE_PNG_INVALID); // 验证码校验出错
            }
        }
        SoUser soUser = new SoUser();
        soUser.setUserNo(userNo);
        soUser.setPassword(password);
        SoUser userFind = soUserService.findByUserInfo(soUser);  // 根据用户名和密码，查询数据库信息
        if (userFind == null) {
            throw new ExUserException(ErrorCode.USER_LOGIN_ERROR); // 未查到信息抛出异常
        }
        String token = tokenService.getToken(userFind);
        if (StringUtil.isNullOrEmpty(token)) {
            throw new ExSysException(ErrorCode.TOKEN_CREATION_ERROR); // TOKEN生成失败抛出异常
        }
        SoUser upUser = new SoUser();
        upUser.setToken(token);
        upUser.setUserNo(userFind.getUserNo());
        soUserService.updateOneUser(upUser); // 设置TOKEN到用户表中
        userFind.setToken(token); // TOKEN 写入返回信息
        userFind.setPassword(""); // 清空返回信息的用户密码
        userFind.setIsVerifyCode(isOrNoVerifyCode);
        writeCookie(response, "token", token, 3600); // 设置 cookie
        getSystemConfig(userFind); // 获取系统配置信息
        return ResMessage.success(userFind);
    }

    /**
     * 配置信息写入到用户信息中
     *
     * @param userFind 用户信息
     */
    public void getSystemConfig(SoUser userFind) {
        String remoteImgDomainType = redisTemplate.get("app_config_img_save_type");
        if (StringUtil.isNullOrEmpty(remoteImgDomainType)) { // redis读取配置信息失败
            SoConfig soConfig = new SoConfig();
            soConfig.setGroup("app_config");
            soConfig.setKey("img_save_type");
            remoteImgDomainType = soConfigService.getConfigValue(soConfig); // 远程图片访问地址
            redisTemplate.set5ks("app_config_img_save_type", remoteImgDomainType);
        }

        // TODO 根据不同的remoteImgDomainType，确定图片服务器的地址。qnu_img_save（七牛云）

        if (remoteImgDomainType.equals("qnu_img_save")) { // redis读取配置信息失败
            String remoteImgDomain = redisTemplate.get("qnu_img_save_base_url");
            if (StringUtil.isNullOrEmpty(remoteImgDomain)) {
                SoConfig soConfig = new SoConfig();
                soConfig.setGroup("qnu_img_save");
                soConfig.setKey("base_url");
                remoteImgDomain = soConfigService.getConfigValue(soConfig);
                redisTemplate.set5ks("qnu_img_save_base_url", remoteImgDomain);
            }
            userFind.setRemoteImgDomain(remoteImgDomain);
        }
    }

    /**
     * 查询用户菜单列表
     *
     * @param request 请求信息
     * @return 菜单列表
     */
    @UserLoginToken
    @RequestMapping("api/loginService/menu")
    @ResponseBody
    public String getMenuList(HttpServletRequest request) {
        String token = request.getHeader("Authorization"); // 从http请求头中取出 token(Authorization)
        String userNo = JWT.decode(token).getAudience().get(0);
        SoUser user = new SoUser();
        user.setUserNo(userNo);
        return ResMessage.success(soUserService.getMenuList(user));
    }

    /**
     * cookie 写入
     *
     * @param response   响应
     * @param cookieName 名称
     * @param value      值
     */
    public void writeCookie(HttpServletResponse response, String cookieName, String value, int maxAge) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 退出登录
     *
     * @return 结果
     */
    @PassToken
    @RequestMapping("api/loginService/logout")
    @ResponseBody
    public String logout(HttpServletResponse response) {
        writeCookie(response, "token", null, 0); // 清除前端cookie
        // TODO 清除用户表中的token
        return ResMessage.success();
    }

    /**
     * 根据 token 获取用户信息
     *
     * @param token token
     * @return 返回
     */
    @PassToken
    @RequestMapping("api/loginService/getUserByToken")
    @ResponseBody
    public String getUserByToken(String token) {
        log.info("Token:{}", token);
        if (token == null) { // token认证 -- token为空
            throw new ExUserException(ErrorCode.TOKEN_IS_NULL_ERROR);
        }
        SoUser user = new SoUser(); // 获取token中的userNo
        try {
            user.setUserNo(JWT.decode(token).getAudience().get(0)); // 从token中读取userNo
            log.info("用户号：{}", user.getUserNo());
        } catch (JWTDecodeException | IllegalArgumentException j) {
            j.printStackTrace();
            throw new ExUserException(ErrorCode.TOKEN_GET_ERROR);
        }
        SoUser userFind = soUserService.findByUserInfo(user); // 根据 userNo 从数据库中查询用户
        if (userFind == null) { // 用户不存在
            throw new ExUserException(ErrorCode.USER_EXIST_ERROR);
        }
        log.info("密码：{}", userFind.getPassword()); // 使用password验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userFind.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            throw new ExUserException(ErrorCode.TOKEN_VAL_ERROR);
        }
        userFind.setPassword(""); // 移除密码
        userFind.setToken(token); // 成功信息返回
        getSystemConfig(userFind); // 系统配置信息
        return ResMessage.success(userFind);
    }

    /**
     * token 失效后，获取新的token
     *
     * @param token 旧的token
     * @return 返回
     */
    @PassToken
    @RequestMapping("api/loginService/newToken")
    @ResponseBody
    public String getNewToken(HttpServletResponse response, String token) {
        SoUser user = new SoUser();
        try { // token认证：获取token中的userNo
            user.setUserNo(JWT.decode(token).getAudience().get(0)); // 从token中读取userNo
        } catch (JWTDecodeException | IllegalArgumentException j) {
            j.printStackTrace();
            throw new ExUserException(ErrorCode.TOKEN_GET_ERROR);
        }
        SoUser userFind = soUserService.findByUserInfo(user); // 根据userNo从数据库中查询用户
        if (userFind.getToken().equals(token)) {  // 查到用户信息，设置新的token
            String newToken = tokenService.newToken(userFind);
            userFind.setToken(newToken);
            if (!newToken.equals("")) {
                SoUser upUser = new SoUser();
                upUser.setToken(newToken);
                upUser.setUserNo(userFind.getUserNo());
                soUserService.updateOneUser(upUser); // token更新到user表
            }
        }
        log.info(ResMessage.success(userFind));
        writeCookie(response, "token", userFind.getToken(), 3600); // 设置 cookie
        return ResMessage.success(userFind);
    }
}
