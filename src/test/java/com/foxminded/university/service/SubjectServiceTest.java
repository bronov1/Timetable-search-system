package com.foxminded.university.service;

import com.foxminded.university.dao.SubjectDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceTest {

    @Mock
    SubjectDao subjectDao;
    @InjectMocks
    SubjectService subjectService;

    @Test
    public void getSubject() {
        subjectService.getSubject(1);
        Mockito.verify(subjectDao).get(1);
    }
}
