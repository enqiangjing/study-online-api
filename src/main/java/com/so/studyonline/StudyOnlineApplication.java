package com.so.studyonline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.so.studyonline.mapper")
public class StudyOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyOnlineApplication.class, args);
    }

}
