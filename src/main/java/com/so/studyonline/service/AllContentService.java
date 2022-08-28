package com.so.studyonline.service;

import com.so.studyonline.config.ErrorCode;
import com.so.studyonline.enhance.ResMessage;
import com.so.studyonline.entity.SoAllContent;
import com.so.studyonline.entity.SoArticle;
import com.so.studyonline.entity.SoConfig;
import com.so.studyonline.exception.ExUserException;
import com.so.studyonline.mapper.SoAllContentMapper;
import com.so.studyonline.mapper.SoArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AllContentService {

    private SoAllContentMapper soAllContentMapper;

    @Autowired
    public void setSoAllContentMapper(SoAllContentMapper soAllContentMapper) {
        this.soAllContentMapper = soAllContentMapper;
    }

    private SoConfigService soConfigService;

    @Autowired
    public void setSoConfigService(SoConfigService soConfigService) {
        this.soConfigService = soConfigService;
    }

    private SoArticleMapper soArticleMapper;

    @Autowired
    public void setSoArticleMapper(SoArticleMapper soArticleMapper) {
        this.soArticleMapper = soArticleMapper;
    }


    /**
     * 首页经验交流区信息查询
     *
     * @return 4个分区的结果列表
     */
    public List<Map<String, Object>> getExperience() {
        SoConfig soConfig = new SoConfig();
        List<Map<String, Object>> res = new ArrayList<>();
        soConfig.setGroup("home_experience"); // 查询配置表中 home_experience 分组信息
        soConfig.setStatus("1");
        List<SoConfig> listSoConfig = soConfigService.getConfigList(soConfig);
        for (SoConfig config : listSoConfig) { // 循环读取 home_experience 中的值
            Map<String, Object> resItem = new HashMap<>();
            soConfig = config;
            SoAllContent soAllContent = new SoAllContent();
            soAllContent.setExtraA(soConfig.getValue()); // 根据区块配置，查询内容信息
            List<SoAllContent> listSoContent = soAllContentMapper.findExperience(soAllContent);
            resItem.put("list", listSoContent);
            resItem.put("title", soConfig.getName());
            res.add(resItem);
        }
        return res;
    }

    /**
     * 查询热门视频
     *
     * @return 视频列表
     */
    public List<SoAllContent> getFireVideo() {
        SoAllContent soAllContent = new SoAllContent();
        soAllContent.setType("video");
        return soAllContentMapper.findFireVideo(soAllContent);
    }

    /**
     * content表信息查询
     *
     * @param soAllContent 查询条件
     * @return 结果列表
     */
    public Map<String, Object> allSearch(SoAllContent soAllContent) {
        soAllContent.setPageIndex((soAllContent.getPageIndex() - 1) * soAllContent.getPageNum());
        List<SoAllContent> listSoContent = soAllContentMapper.findAllContentLike(soAllContent);
        int total = soAllContentMapper.findAllContentLikeTotal(soAllContent);
        Map<String, Object> res = new HashMap<>();
        res.put("data", listSoContent);
        res.put("total", total);
        return res;
    }

    /**
     * 文章编辑
     *
     * @param soArticle    文章信息
     * @param soAllContent 内容信息
     * @return
     */
    public boolean articleEdit(SoArticle soArticle, SoAllContent soAllContent) {
        try {
            soArticleMapper.updateArticle(soArticle);
            soAllContentMapper.updateContentItem(soAllContent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExUserException(ErrorCode.ARTICLE_EDIT_ERROR);
        }
    }

    /**
     * 新建文章
     *
     * @param soArticle    文章内容
     * @param soAllContent 文章信息
     * @return 文章建立的结果
     */
    public boolean articleCreation(SoArticle soArticle, SoAllContent soAllContent) {
        try {
            soAllContentMapper.creationItem(soAllContent); // 插入信息表
            soArticle.setArticleId(soAllContent.getId()); // 获取文章ID
            soArticleMapper.creationItem(soArticle); // 插入文章正文表
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 查找文章具体信息
     *
     * @param soArticle 查询条件
     * @return 返回信息
     */
    public Map<String, Object> articleGet(SoArticle soArticle) {
        log.info("id:{}---articleId:{}", soArticle.getId(), soArticle.getArticleId()); // 传入数据校验？
        SoAllContent soAllContent = soAllContentMapper.findById(soArticle.getArticleId()); // 查询文章概述信息
        soArticle = soArticleMapper.getArticleContent(soArticle); // 文章具体内容
        Map<String, Object> res = new HashMap<>(); // 返回信息 返回整合
        res.put("id", soAllContent.getId());
        res.put("title", soAllContent.getTitle());
        res.put("article", soArticle.getArticle());
        res.put("content", soAllContent.getContent());
        res.put("author", soAllContent.getAuthor());
        res.put("readTimes", soAllContent.getReadTimes());
        res.put("discussTimes", soAllContent.getDiscussTimes());
        res.put("subject", soAllContent.getExtraA());
        // 信息整合返回
        return res;
    }

    /**
     * 查询热门排行榜列表
     *
     * @param soAllContent 查询条件
     * @return 查询结果
     */
    public List<SoAllContent> getFireOrder(SoAllContent soAllContent) {
        List<SoAllContent> listSoContent = null;
        if (soAllContent.getOrderType().equals("about")) {
            listSoContent = soAllContentMapper.getFireOrder(soAllContent);
        }

        return listSoContent;
    }
}
