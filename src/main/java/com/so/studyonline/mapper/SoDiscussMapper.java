package com.so.studyonline.mapper;

import com.so.studyonline.entity.SoDiscuss;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SoDiscussMapper {

    List<SoDiscuss> findSoDiscuss(SoDiscuss soDiscuss);

    List<SoDiscuss> findDoDiscussAddUserName(SoDiscuss soDiscuss);

    int addDiscuss(SoDiscuss soDiscuss);

    int getFloorMax(Integer topicId);
}
