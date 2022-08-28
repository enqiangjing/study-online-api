package com.so.studyonline.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "qnu.config")
public class QiNiuYun {
    private String qnu_access_key;
    private String qnu_secret_key;
    private String qnu_name;
    private String qnu_value;

    public String getQnu_access_key() {
        return qnu_access_key;
    }

    public void setQnu_access_key(String qnu_access_key) {
        this.qnu_access_key = qnu_access_key;
    }

    public String getQnu_secret_key() {
        return qnu_secret_key;
    }

    public void setQnu_secret_key(String qnu_secret_key) {
        this.qnu_secret_key = qnu_secret_key;
    }

    public String getQnu_name() {
        return qnu_name;
    }

    public void setQnu_name(String qnu_name) {
        this.qnu_name = qnu_name;
    }

    public String getQnu_value() {
        return qnu_value;
    }

    public void setQnu_value(String qnu_value) {
        this.qnu_value = qnu_value;
    }
}
