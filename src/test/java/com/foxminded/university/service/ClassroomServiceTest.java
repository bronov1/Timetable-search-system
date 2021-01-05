package com.foxminded.university.service;

import com.foxminded.university.dao.ClassroomDao;

import com.foxminded.university.entity.Classroom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClassroomServiceTest {

    @Mock
    ClassroomDao classroomDao;
    @InjectMocks
    ClassroomService classroomService;
    @Captor
    ArgumentCaptor<Integer> argCaptor;

    @Test
    public void getClassroom() {
        int randomNumber = ArgumentMatchers.anyInt();
        classroomService.getClassroom(randomNumber);
        Mockito.verify(classroomDao).get(argCaptor.capture(), Classroom.class);
        Assertions.assertEquals(randomNumber, argCaptor.getValue());
    }

    @Test
    public void getAllClassrooms() {
        classroomService.getAllClassrooms();
        Mockito.verify(classroomDao).getAll(Classroom.class);
    }
}
