package com.so.studyonline.mapper;

import com.so.studyonline.entity.SoArticle;
import org.springframework.stereotype.Component;

@Component
public interface SoArticleMapper {


    SoArticle getArticleContent(SoArticle soArticle);

    void updateArticle(SoArticle soArticle);

    int creationItem(SoArticle soArticle);
}
