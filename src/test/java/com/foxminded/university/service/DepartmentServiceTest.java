package com.foxminded.university.service;


import com.foxminded.university.dao.DepartmentDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    DepartmentDao departmentDao;
    @InjectMocks
    DepartmentService departmentService;

    @Test
    public void getDepartment() {
        departmentService.getDepartment(1);
        Mockito.verify(departmentDao).get(1);
    }
}
