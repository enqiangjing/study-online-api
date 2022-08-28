package com.so.studyonline.mapper;

import com.so.studyonline.entity.SoCurriculumInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SoCurriculumInfoMapper {
    List<SoCurriculumInfo> findCurriculum(SoCurriculumInfo soCurriculumInfo);

    List<SoCurriculumInfo> findCurriculumPubLimit4(SoCurriculumInfo soCurriculumInfo);

    SoCurriculumInfo findCurriculumById(SoCurriculumInfo soCurriculumInfo);
}
