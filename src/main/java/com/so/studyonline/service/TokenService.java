package com.so.studyonline.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.so.studyonline.entity.SoUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Token 服务
 */
@Slf4j
@Service
public class TokenService {

    /**
     * 根据用户名和密码创建 token
     *
     * @param user 用户信息
     * @return token 为空或加密后的字符串
     */
    public String getToken(SoUser user) {
        // token 时效 - 开始时间
        Date start = new Date();
        // token 时效 - 截止时间，设置 token 时效为 2 小时
        long currentTime = System.currentTimeMillis() + 60 * 60 * 2 * 1000;
        Date end = new Date(currentTime);
        // token 创建
        String token = "";
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            log.info("{} 登录成功，Token有效期：{}---{}", user.getUserNo(), format.format(start), format.format(end));
            token = JWT.create().withAudience(user.getUserNo()).withIssuedAt(start).withExpiresAt(end)
                    .sign(Algorithm.HMAC256(user.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 刷新 token
     *
     * @param user 用户信息
     * @return 返回新的 token
     */
    public String newToken(SoUser user) {
        // TODO 此处可以做更多的处理
        return getToken(user);
    }
}
