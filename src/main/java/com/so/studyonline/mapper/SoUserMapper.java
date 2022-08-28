package com.so.studyonline.mapper;

import com.so.studyonline.entity.SoUser;
import org.springframework.stereotype.Component;

@Component
public interface SoUserMapper {

    SoUser userVerify(String userNo, String password);  // 用户验证：账号+密码

    SoUser findByUserInfo(SoUser soUser); // 用户查询 limit 1

    int addUser(SoUser user); // 新增用户

    void updateOneUser(SoUser user); // 更新用户信息 by id or userNo
}
