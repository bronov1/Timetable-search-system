package com.foxminded.university.service;

import com.foxminded.university.dao.LectureDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LectureServiceTest {

    @Mock
    LectureDao lectureDao;
    @InjectMocks
    LectureService lectureService;

    @Test
    public void getAllLectures() {
        lectureService.getAllLectures();
        Mockito.verify(lectureDao).getAll();
    }
}
