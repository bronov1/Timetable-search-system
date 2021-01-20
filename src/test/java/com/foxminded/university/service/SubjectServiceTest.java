package com.foxminded.university.service;

import com.foxminded.university.dao.SubjectRepository;
import com.foxminded.university.entity.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceTest {

    @Mock
    SubjectRepository subjectRepository;
    @InjectMocks
    SubjectService subjectService;
    @Captor
    ArgumentCaptor<Integer> argCaptor;

    @Test
    public void getSubject() {
        int randomNumber = ArgumentMatchers.anyInt();
        subjectService.getSubject(randomNumber);
        Mockito.verify(subjectRepository).findById(argCaptor.capture());
        Assertions.assertEquals(randomNumber, argCaptor.getValue());
    }

    @Test
    public void getAllSubjects() {
        subjectService.getAllSubjects();
        Mockito.verify(subjectRepository).findAll();
    }
}
