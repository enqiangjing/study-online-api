package com.so.studyonline.service;

import com.alibaba.fastjson.JSONObject;
import com.so.studyonline.entity.SoCurriculumInfo;
import com.so.studyonline.entity.SoUserClass;
import com.so.studyonline.entity.SoVideoChapter;
import com.so.studyonline.mapper.SoCurriculumInfoMapper;
import com.so.studyonline.mapper.SoUserClassMapper;
import com.so.studyonline.mapper.SoVideoChapterMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ClassInfoService {
    private SoUserClassMapper soUserClassMapper;

    @Autowired
    public void setSoUserClassMapper(SoUserClassMapper soUserClassMapper) {
        this.soUserClassMapper = soUserClassMapper;
    }

    private SoVideoChapterMapper soVideoChapterMapper;

    @Autowired
    public void setSoVideoChapterMapper(SoVideoChapterMapper soVideoChapterMapper) {
        this.soVideoChapterMapper = soVideoChapterMapper;
    }

    private SoCurriculumInfoMapper soCurriculumInfoMapper;

    @Autowired
    public void setSoCurriculumInfoMapper(SoCurriculumInfoMapper soCurriculumInfoMapper) {
        this.soCurriculumInfoMapper = soCurriculumInfoMapper;
    }

    /**
     * 查询用户名下课程列表
     *
     * @param userId 用户ID
     * @return 课程列表
     */
    public List<SoUserClass> findUsersClass(int userId, int videoId) {
        SoUserClass soUserClass = new SoUserClass();
        soUserClass.setBuyUserId(userId);
        soUserClass.setClassId(videoId);
        return soUserClassMapper.findUsersClass(soUserClass);
    }

    /**
     * 根据课程id查询课程信息
     *
     * @param id 课程ID
     * @return 课程i信息
     */
    public SoCurriculumInfo findCurriculumById(int id) {
        SoCurriculumInfo soCurriculumInfo = new SoCurriculumInfo();
        soCurriculumInfo.setId(id);
        return soCurriculumInfoMapper.findCurriculumById(soCurriculumInfo);
    }

    /**
     * 查询视频课程章节信息
     *
     * @param id 课程ID
     * @return 章节列表
     */
    public List<List<SoVideoChapter>> getVideoCurriculumChapter(int id) {
        SoVideoChapter soVideoChapter = new SoVideoChapter();
        soVideoChapter.setVideoId(id);
        List<SoVideoChapter> soVideoChapterList = soVideoChapterMapper.findVideoChapterByVideoId(soVideoChapter);
        List<List<SoVideoChapter>> returnList = new ArrayList<>();
        List<SoVideoChapter> returnListItem = new ArrayList<>();
        long part = 0;
        for (SoVideoChapter soVideoChapterItem : soVideoChapterList) {
            if (part != soVideoChapterItem.getPart()) {
                if (part != 0) {
                    returnListItem = new ArrayList<>();
                }
                part = soVideoChapterItem.getPart();
                returnList.add(returnListItem);
            }
            returnListItem.add(soVideoChapterItem);
        }
        return returnList;
    }

    /**
     * 多条件查询课程列表
     *
     * @param soCurriculumInfo 查询条件
     * @return 课程列表
     */
    public List<SoCurriculumInfo> getCurriculumList(SoCurriculumInfo soCurriculumInfo, String searchType) {
        if (searchType.equals("public")) {
            return soCurriculumInfoMapper.findCurriculumPubLimit4(soCurriculumInfo);
        }
        return soCurriculumInfoMapper.findCurriculum(soCurriculumInfo);
    }
}
