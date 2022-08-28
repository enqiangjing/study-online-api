package com.so.studyonline.service;

import com.alibaba.fastjson.JSONObject;
import com.so.studyonline.config.ErrorCode;
import com.so.studyonline.entity.SoDiscuss;
import com.so.studyonline.entity.SoDiscussReply;
import com.so.studyonline.exception.ExUserException;
import com.so.studyonline.mapper.SoDiscussMapper;
import com.so.studyonline.mapper.SoDiscussReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CommentService {

    private SoDiscussMapper soDiscussMapper;

    @Autowired
    public void setSoDiscussMapper(SoDiscussMapper soDiscussMapper) {
        this.soDiscussMapper = soDiscussMapper;
    }

    private SoDiscussReplyMapper soDiscussReplyMapper;

    @Autowired
    public void setSoDiscussReplyMapper(SoDiscussReplyMapper soDiscussReplyMapper) {
        this.soDiscussReplyMapper = soDiscussReplyMapper;
    }

    /**
     * 查询评论你信息
     *
     * @param soDiscuss 查询条件
     * @return 结果列表
     */
    public List<Object> getDiscuss(SoDiscuss soDiscuss) {
        log.info(JSONObject.toJSONString(soDiscuss));
        List<SoDiscuss> listSoDiscuss = soDiscussMapper.findDoDiscussAddUserName(soDiscuss); // topicId 查询评论
        int row = listSoDiscuss.size();
        if (row == 0) { // 评论数量为 0，返回空
            return null;
        }
        SoDiscussReply soDiscussReply = new SoDiscussReply();
        soDiscussReply.setTopicId(soDiscuss.getTopicId()); // 查询对评论的回复
        List<SoDiscussReply> soDiscussReplyList = soDiscussReplyMapper.findSoDiscussReplyAndUserName(soDiscussReply);
        List<Object> formDiscuss = new ArrayList<>();
        for (SoDiscuss discuss : listSoDiscuss) { // 整合评论及回复
            Map<String, Object> formDiscussItem = new HashMap<>();
            List<SoDiscussReply> soDiscussReplyItem = new ArrayList<>();
            for (SoDiscussReply discussReply : soDiscussReplyList) {
                if (discussReply.getDiscussId() == discuss.getId()) {
                    soDiscussReplyItem.add(discussReply);
                }
            }
            formDiscussItem.put("out", discuss);
            formDiscussItem.put("inside", soDiscussReplyItem);
            formDiscuss.add(formDiscussItem);
        }

        return formDiscuss;
    }

    /**
     * 添加评论
     *
     * @param soDiscuss 评论信息
     * @return 评论结果
     */
    public boolean addDiscuss(SoDiscuss soDiscuss) {
        log.info(JSONObject.toJSONString(soDiscuss)); // 传入值
        soDiscuss.setStatus(1);
        soDiscuss.setDiscussTime(new Timestamp(System.currentTimeMillis()));
        int floor = 0; // 楼高度+1
        try {
            floor = soDiscussMapper.getFloorMax(soDiscuss.getTopicId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        soDiscuss.setFloor(floor + 1);
        try {
            soDiscussMapper.addDiscuss(soDiscuss);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExUserException(ErrorCode.ADD_COMMENT_ERROR);
        }
        return true;
    }

    /**
     * 添加层回复
     *
     * @param soDiscussReply 回复信息
     * @return 结果
     */
    public boolean addDiscussReply(SoDiscussReply soDiscussReply) {
        log.info(JSONObject.toJSONString(soDiscussReply)); // 传入值
        int floor = 0; // 层高度+1
        try {
            floor = soDiscussReplyMapper.getFloorMax(soDiscussReply);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("层高度+1：{}", floor + 1);
        soDiscussReply.setFloor(floor + 1);
        soDiscussReply.setReplyTime(new Timestamp(System.currentTimeMillis()));
        try {
            soDiscussReplyMapper.addDiscussReply(soDiscussReply);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExUserException(ErrorCode.ADD_COMMENT_ERROR);
        }
        log.info(JSONObject.toJSONString(soDiscussReply));
        return true;
    }
}
