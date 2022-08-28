package com.so.studyonline.mapper;

import com.so.studyonline.entity.VerifyCode;
import org.springframework.stereotype.Component;

@Component
public interface VerifyCodeMapper {

    void insertCode(VerifyCode vc);

    VerifyCode findById(int id);

    VerifyCode findByIpAndTime(String findIp);

    void updateStatus(int id);
}
