package com.so.studyonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.so.studyonline.annotation.PassToken;
import com.so.studyonline.annotation.UserLoginToken;
import com.so.studyonline.config.ErrorCode;
import com.so.studyonline.enhance.DateTools;
import com.so.studyonline.enhance.ResMessage;
import com.so.studyonline.entity.SoAllContent;
import com.so.studyonline.entity.SoArticle;
import com.so.studyonline.entity.SoUser;
import com.so.studyonline.exception.ExUserException;
import com.so.studyonline.service.AllContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
public class AllContentController {
    private AllContentService allContentService;

    @Autowired
    public void setAllContentService(AllContentService allContentService) {
        this.allContentService = allContentService;
    }


    /**
     * 首页经验交流区块内容查询
     *
     * @return JSON 列表数据
     */
    @PassToken
    @RequestMapping("api/contentService/experience")
    @ResponseBody
    public String getExperience() {
        return ResMessage.success(allContentService.getExperience());
    }

    /**
     * @return ｛JSON｝ 返回热门视频列表
     * @apiNote getFireVideo && fireVideo
     */
    @PassToken
    @RequestMapping("api/contentService/fireVideo")
    @ResponseBody
    public String getFireVideo() {
        return ResMessage.success(allContentService.getFireVideo());
    }

    /**
     * @param soAllContent 传入搜索数据
     * @return ｛JSON｝ 搜索结果列表
     * @apiNote allSearch && 页面搜索功能
     */
    @PassToken
    @RequestMapping("api/contentService/allSearch")
    @ResponseBody
    public String allSearch(@RequestBody SoAllContent soAllContent) {
        return ResMessage.success(allContentService.allSearch(soAllContent));
    }

    /**
     * @param soAllContent 传入搜索数据
     * @return ｛JSON｝ 搜索结果列表
     * @apiNote allSearch && 页面搜索功能
     */
    @UserLoginToken
    @RequestMapping("api/contentService/allSearchLogin")
    @ResponseBody
    public String allSearchLogin(HttpServletRequest request, @RequestBody SoAllContent soAllContent) {
        String token = request.getHeader("Authorization");
        SoUser user = new SoUser(); // 获取 token 中的 userNo
        try { // 从 token 中读取 userNo
            user.setUserNo(JWT.decode(token).getAudience().get(0));
        } catch (JWTDecodeException | IllegalArgumentException j) {
            throw new ExUserException(ErrorCode.TOKEN_READ_ERROR);
        }
        soAllContent.setAuthor(user.getUserNo());
        return ResMessage.success(allContentService.allSearch(soAllContent));
    }

    /**
     * 编辑文章
     *
     * @param soArticle 文章信息
     * @return 编辑结果
     */
    @UserLoginToken
    @RequestMapping("api/contentService/article_edit")
    @ResponseBody
    public String articleEdit(@RequestBody SoArticle soArticle) {
        log.info("article-id:{}", soArticle.getArticleId());
        SoAllContent soAllContent = new SoAllContent();
        soAllContent.setId(soArticle.getArticleId());
        soAllContent.setTitle(soArticle.getTitle());
        soAllContent.setContent(soArticle.getContent());
        soAllContent.setStatus(soArticle.getStatus());
        soAllContent.setExtraA(soArticle.getSubject());
        if (allContentService.articleEdit(soArticle, soAllContent)) {
            return ResMessage.success();
        }
        return ResMessage.error();
    }

    /**
     * 新建文章
     *
     * @param soArticle 文章信息
     * @return 建立结果
     */
    @UserLoginToken
    @RequestMapping("api/contentService/article_creation")
    @ResponseBody
    public String articleCreation(@RequestBody SoArticle soArticle) {
        log.info("新建文章信息 -- {}", JSONObject.toJSONString(soArticle));

        SoAllContent soAllContent = new SoAllContent();
        soAllContent.setTitle(soArticle.getTitle());
        soAllContent.setContent(soArticle.getContent());
        soAllContent.setAuthor(soArticle.getUserNo());
        soAllContent.setReadTimes(0);
        soAllContent.setDiscussTimes(0);
        soAllContent.setType("article");
        soAllContent.setCreatedTime(DateTools.currentDate());
        soAllContent.setUpdateTime(DateTools.currentDate());
        soAllContent.setDeletedTime(DateTools.currentDate());
        soAllContent.setStatus(soArticle.getStatus());
        soAllContent.setExtraA(soArticle.getSubject());

        return ResMessage.success(allContentService.articleCreation(soArticle, soAllContent));
    }

    /**
     * 获取文章详细信息
     *
     * @param soArticle 查询条件
     * @return 查询结果
     */
    @PassToken
    @RequestMapping("api/contentService/article_get")
    @ResponseBody
    public String articleGet(@RequestBody SoArticle soArticle) {
        return ResMessage.success(allContentService.articleGet(soArticle));
    }

    /**
     * 获取排行榜列表
     *
     * @param soAllContent 搜索条件
     * @return 搜索结果
     */
    @PassToken
    @RequestMapping("api/contentService/getFireOrder")
    @ResponseBody
    public String getFireOrder(@RequestBody SoAllContent soAllContent) {
        return ResMessage.success(allContentService.getFireOrder(soAllContent));
    }
}
