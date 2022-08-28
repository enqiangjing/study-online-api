package com.so.studyonline.service;

import com.so.studyonline.config.ErrorCode;
import com.so.studyonline.entity.SoConfig;
import com.so.studyonline.exception.ExSysException;
import com.so.studyonline.mapper.SoConfigMapper;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SoConfigService {
    private SoConfigMapper soConfigMapper;

    @Autowired
    public void setSoConfigMapper(SoConfigMapper soConfigMapper) {
        this.soConfigMapper = soConfigMapper;
    }

    /**
     * 查询配置信息的 value
     *
     * @param soConfig 查询条件
     * @return value
     */
    public String getConfigValue(SoConfig soConfig) {
        SoConfig soConfigFind = soConfigMapper.findConfigByKeyAndGroup(soConfig);
        if (soConfigFind == null || StringUtil.isNullOrEmpty(soConfigFind.getValue())) {
            throw new ExSysException(ErrorCode.CONFIG_INFO_NULL);
        }
        return soConfigFind.getValue();
    }

    /**
     * 查询配置记录完整信息（一条）
     *
     * @param soConfig 查询条件
     * @return 查询结果
     */
    public SoConfig getConfigItem(SoConfig soConfig) {
        return soConfigMapper.findConfigByKeyAndGroup(soConfig);
    }

    /**
     * 查询配置记录列表（按group）
     *
     * @param soConfig 查询条件
     * @return 配置组列表
     */
    public List<SoConfig> getConfigList(SoConfig soConfig) {
        return soConfigMapper.findConfig(soConfig);
    }
}
