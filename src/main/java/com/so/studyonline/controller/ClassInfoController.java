package com.so.studyonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.so.studyonline.annotation.PassToken;
import com.so.studyonline.annotation.UserLoginToken;
import com.so.studyonline.enhance.ResMessage;
import com.so.studyonline.entity.SoCurriculumInfo;
import com.so.studyonline.service.ClassInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ClassInfoController {
    private ClassInfoService classInfoService;

    @Autowired
    public void setClassInfoService(ClassInfoService classInfoService) {
        this.classInfoService = classInfoService;
    }

    /**
     * 用户名下课程列表（查询用户已经购买的课程）
     *
     * @param searchInfo 查询条件
     * @return 列表信息
     */
    @PassToken
    @RequestMapping("api/classInfoService/getUserClassList")
    @ResponseBody
    public String getUserClassList(@RequestBody JSONObject searchInfo) {
        int userId = Integer.parseInt(searchInfo.getString("userId"));
        int videoId = 0;
        try {
            videoId = Integer.parseInt(searchInfo.getString("videId"));
        } catch (Exception e) {
            log.info("未传入课程ID", e);
        }
        return ResMessage.success(classInfoService.findUsersClass(userId, videoId));
    }

    /**
     * 查询课程章节信息
     *
     * @param jsonObject 查询条件
     * @return 课程章节信息
     */
    @UserLoginToken
    @RequestMapping("api/classInfoService/videoChapter")
    @ResponseBody
    public String getVideoCurriculumChapter(@RequestBody JSONObject jsonObject) {
        int id = Integer.parseInt(jsonObject.get("id").toString());
        Integer chapter = Integer.parseInt(jsonObject.get("chapter").toString());
        log.info("videoChapter: {}--{}", id, chapter);
        return ResMessage.success(classInfoService.getVideoCurriculumChapter(id));
    }

    /**
     * 查询课程详细信息
     *
     * @param searchInfo 查询条件
     * @return 课程详细信息
     */
    @PassToken
    @RequestMapping("api/classInfoService/getCurriculumInfo")
    @ResponseBody
    public String getCurriculumInfo(@RequestBody JSONObject searchInfo) {
        int classId = Integer.parseInt(searchInfo.getString("classId"));
        return ResMessage.success(classInfoService.findCurriculumById(classId));
    }

    /**
     * 多条件查询公开课程列表
     *
     * @param soCurriculumInfo 查询条件
     * @return 课程列表
     */
    @PassToken
    @RequestMapping("api/classInfoService/getCurriculumListPub")
    @ResponseBody
    public String getCurriculumListPub(@RequestBody SoCurriculumInfo soCurriculumInfo) {
        log.info("[getCurriculumList] 请求参数: {}", JSONObject.toJSONString(soCurriculumInfo));
        return ResMessage.success(classInfoService.getCurriculumList(soCurriculumInfo, "public"));
    }

    /**
     * 多条件查询公开课程列表
     *
     * @param soCurriculumInfo 查询条件
     * @return 课程列表
     */
    @PassToken
    @RequestMapping("api/classInfoService/getCurriculumList")
    @ResponseBody
    public String getCurriculumList(@RequestBody SoCurriculumInfo soCurriculumInfo) {
        log.info("[getCurriculumList] 请求参数: {}", JSONObject.toJSONString(soCurriculumInfo));
        return ResMessage.success(classInfoService.getCurriculumList(soCurriculumInfo, ""));
    }
}
