package com.so.studyonline.mapper;

import com.so.studyonline.entity.SoUserClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SoUserClassMapper {
    List<SoUserClass> findUsersClass(SoUserClass soUserClass);

    SoUserClass findClassById(SoUserClass soUserClass);
}
