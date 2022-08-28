package com.so.studyonline.mapper;

import com.so.studyonline.entity.SoVideoChapter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SoVideoChapterMapper {

    public List<SoVideoChapter> findVideoChapter(SoVideoChapter soVideoChapter);

    public List<SoVideoChapter> findVideoChapterByVideoId(SoVideoChapter soVideoChapter);
}
