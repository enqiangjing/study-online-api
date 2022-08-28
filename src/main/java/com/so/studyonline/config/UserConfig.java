package com.so.studyonline.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")
public class UserConfig {

    private String up_file_path;

    public String getUp_file_path() {
        return up_file_path;
    }

    public void setUp_file_path(String up_file_path) {
        this.up_file_path = up_file_path;
    }
}
