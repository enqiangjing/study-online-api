package com.so.studyonline.mapper;

import com.so.studyonline.entity.SoMenulist;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SoMenulistMapper {
    public List<SoMenulist> getUserMenu(SoMenulist soMenulist);  // 查询用户菜单列表

}
