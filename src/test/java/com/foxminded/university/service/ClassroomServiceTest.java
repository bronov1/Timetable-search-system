package com.foxminded.university.service;

import com.foxminded.university.dao.ClassroomRepository;
import com.foxminded.university.entity.Classroom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClassroomServiceTest {

    @Mock
    ClassroomRepository classroomRepository;
    @InjectMocks
    ClassroomService classroomService;
    @Captor
    ArgumentCaptor<Integer> argCaptor;

    @Test
    public void getClassroom() {
        int randomNumber = ArgumentMatchers.anyInt();
        classroomService.getClassroom(randomNumber);
        Mockito.verify(classroomRepository).findById(argCaptor.capture());
        Assertions.assertEquals(randomNumber, argCaptor.getValue());
    }

    @Test
    public void getAllClassrooms() {
        classroomService.getAllClassrooms();
        Mockito.verify(classroomRepository).findAll();
    }
}
