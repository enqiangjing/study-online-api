package com.so.studyonline.mapper;

import com.so.studyonline.entity.SoDiscussReply;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SoDiscussReplyMapper {
    List<SoDiscussReply> findSoDiscussReply(SoDiscussReply soDiscussReply);

    List<SoDiscussReply> findSoDiscussReplyAndUserName(SoDiscussReply soDiscussReply);

    int getFloorMax(SoDiscussReply soDiscussReply);

    int addDiscussReply(SoDiscussReply soDiscussReply);
}
