package com.so.studyonline.intercept;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.so.studyonline.annotation.PassToken;
import com.so.studyonline.annotation.UserLoginToken;
import com.so.studyonline.entity.SoUser;
import com.so.studyonline.service.SoUserService;
import com.so.studyonline.enhance.ResMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 请求拦截后进行处理
 */
@Slf4j
@Component // annotation-a
public class LoginInterceptor implements HandlerInterceptor {
    // 非 controller 使用 Autowired 注解；annotation-a -- e 5步
    // annotation-b
    private SoUserService soUserService;

    @Autowired // annotation-c
    public void setSoUserService(SoUserService soUserService) {
        this.soUserService = soUserService;
    }

    // annotation-d
    public static LoginInterceptor loginInterceptor;

    // annotation-e
    @PostConstruct
    public void init() {
        loginInterceptor = this;
        loginInterceptor.soUserService = this.soUserService;
    }

    /**
     * @apiNote 登录拦截器
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object)
            throws Exception {
        // 从 http 请求头中取出 token(Authorization)
        String token = request.getHeader("Authorization");
        // 如果不是映射到方法直接通过 --> 资源允许
        log.info("[preHandle] {}", object);
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        // 检查是否有 PassToken 注解，有则跳过 token 认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 检查是否有 UserLoginToken 注解，有则需要 token 认证
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    // throw new RuntimeException("无token，请重新登录");
                    // throw new LoginException("001", "未登录"); // 抛出异常
                    returnJson(response, ResMessage.error("001003", "请求未携带token，请重新登录"));
                    return false;
                }
                // 获取 token 中的 userNo
                SoUser user = new SoUser();
                try {
                    // 从 token 中读取 userNo
                    user.setUserNo(JWT.decode(token).getAudience().get(0));
                } catch (JWTDecodeException | IllegalArgumentException j) {
                    // throw new RuntimeException("401");
                    // j.printStackTrace();
                    returnJson(response, ResMessage.error("001004", "token解析失败，请重新登录"));
                    return false;
                }
                // 根据 userNo 从数据库中查询用户
                SoUser userFind = loginInterceptor.soUserService.findByUserInfo(user);
                if (userFind == null) {
                    // throw new RuntimeException("用户不存在，请重新登录");
                    returnJson(response, ResMessage.error("001005", "用户信息不存在，请重新登录"));
                    return false;
                }
                // 使用 password 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userFind.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    // throw new RuntimeException("401");
                    returnJson(response, ResMessage.error("001006", "签名验证不通过，请重新登录"));
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    /**
     * 自定义拦截后返回信息
     *
     * @param response 相应
     * @param result   返回json
     */
    private void returnJson(HttpServletResponse response, String result) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter res = response.getWriter()) {
            res.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @apiNote 生成视图时执行，用于处理异常
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
                                Exception exception) {
        // ------------- //
    }

    /**
     * @apiNote 生成视图之前执行
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) {
        // ------------- //
    }

}
