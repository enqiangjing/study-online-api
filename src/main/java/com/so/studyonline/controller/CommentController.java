package com.so.studyonline.controller;

import com.so.studyonline.annotation.PassToken;
import com.so.studyonline.annotation.UserLoginToken;
import com.so.studyonline.enhance.ResMessage;
import com.so.studyonline.entity.SoDiscuss;
import com.so.studyonline.entity.SoDiscussReply;
import com.so.studyonline.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class CommentController {

    private CommentService commentService;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 查找评论
     *
     * @param soDiscuss 评论信息
     * @return 查找结果
     */
    @PassToken
    @RequestMapping("api/commentService/discuss")
    @ResponseBody
    public String getDiscuss(@RequestBody SoDiscuss soDiscuss) {
        return ResMessage.success(commentService.getDiscuss(soDiscuss));
    }

    /**
     * 添加评论
     *
     * @param soDiscuss 评论信息
     * @return 添加结果
     */
    @UserLoginToken
    @RequestMapping("api/commentService/addDiscuss")
    @ResponseBody
    public String addDiscuss(@RequestBody SoDiscuss soDiscuss) {
        return ResMessage.success(commentService.addDiscuss(soDiscuss));
    }

    /**
     * 添加楼层回复信息
     *
     * @param soDiscussReply 回顾结果
     * @return 回顾结果
     */
    @UserLoginToken
    @RequestMapping("api/commentService/addDiscussReply")
    @ResponseBody
    public String addDiscussReply(@RequestBody SoDiscussReply soDiscussReply) {
        return ResMessage.success(commentService.addDiscussReply(soDiscussReply));
    }
}
