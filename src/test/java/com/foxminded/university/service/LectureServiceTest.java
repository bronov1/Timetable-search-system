package com.foxminded.university.service;

import com.foxminded.university.dao.LectureDao;
import com.foxminded.university.entity.Lecture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LectureServiceTest {

    @Mock
    Lecture lecture;
    @Mock
    LectureDao lectureDao;
    @Spy
    @InjectMocks
    LectureService lectureService;
    @Captor
    ArgumentCaptor<Integer> argCaptor;

    @Test
    public void getAllLectures() {
        lectureService.getAllLectures();
        Mockito.verify(lectureDao).getAll(Lecture.class);
    }

    @Test
    public void save() {
        lectureService.save(lecture);
        Mockito.verify(lectureDao).create(lecture);
    }

    @Test
    public void delete() {
        lectureService.delete(lecture);
        Mockito.verify(lectureDao).delete(lecture);
    }

    @Test
    public void update() {
        lectureService.update(lecture);
        Mockito.verify(lectureService).update(lecture);
    }

    @Test
    public void getLecture() {
        int randomNumber = ArgumentMatchers.anyInt();
        lectureService.getLecture(randomNumber);
        Mockito.verify(lectureDao).get(argCaptor.capture(), Lecture.class);
        Assertions.assertEquals(randomNumber, argCaptor.getValue());
    }
}
