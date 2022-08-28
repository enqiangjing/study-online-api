package com.so.studyonline.mapper;

import org.springframework.stereotype.Component;
import com.so.studyonline.entity.SoConfig;

import java.util.List;

@Component
public interface SoConfigMapper {
    List<SoConfig> findConfig(SoConfig soConfig);

    SoConfig findConfigByKeyAndGroup(SoConfig soConfig);
}
