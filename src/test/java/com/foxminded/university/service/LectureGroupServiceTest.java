package com.foxminded.university.service;

import com.foxminded.university.dao.LectureGroupRepository;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.LectureGroup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LectureGroupServiceTest {

    @Mock
    Lecture lecture;
    @Mock
    LectureGroup lectureGroup;
    @Mock
    LectureGroupRepository lectureGroupRepository;
    @InjectMocks
    LectureGroupService lectureGroupService;

    @Test
    public void save() {
        lectureGroupService.save(lectureGroup);
        Mockito.verify(lectureGroupRepository).save(lectureGroup);
    }

    @Test
    public void deleteGroupsFromLecture() {
        lectureGroupService.deleteGroupsFromLecture(lecture);
        Mockito.verify(lectureGroupRepository).deleteByLecture(lecture);
    }
}
