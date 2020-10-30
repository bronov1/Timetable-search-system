package com.foxminded.university.service;

import com.foxminded.university.dao.ClassroomDao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClassroomServiceTest {

    @Mock
    ClassroomDao classroomDao;
    @InjectMocks
    ClassroomService classroomService;

    @Test
    public void getClassroom() {
        classroomService.getClassroom(1);
        Mockito.verify(classroomDao).get(1);
    }
}
