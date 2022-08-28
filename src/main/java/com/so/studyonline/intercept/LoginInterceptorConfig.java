package com.so.studyonline.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局请求拦截配置
 */
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    /**
     * 拦截所有请求
     * 可配置例外 addPathPatterns("/**").excludePathPatterns("/pub/**","/getVerifyCode")
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }
}