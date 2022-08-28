package com.so.studyonline.mapper;

import com.so.studyonline.entity.SoAllContent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SoAllContentMapper {

    List<SoAllContent> findAllContent(SoAllContent soAllContent);

    SoAllContent findById(long id);

    List<SoAllContent> findExperience(SoAllContent soAllContent);

    List<SoAllContent> findFireVideo(SoAllContent soAllContent);

    List<SoAllContent> findAllContentLike(SoAllContent soAllContent);

    List<SoAllContent> getFireOrder(SoAllContent soAllContent);

    int findAllContentLikeTotal(SoAllContent soAllContent);

    void updateContentItem(SoAllContent soAllContent);

    int creationItem(SoAllContent soAllContent);
}
