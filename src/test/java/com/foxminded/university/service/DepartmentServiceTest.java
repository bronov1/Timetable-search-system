package com.foxminded.university.service;


import com.foxminded.university.dao.DepartmentDao;
import com.foxminded.university.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    DepartmentDao departmentDao;
    @InjectMocks
    DepartmentService departmentService;
    @Captor
    ArgumentCaptor<Integer> argCaptor;

    @Test
    public void getDepartment() {
        int randomNumber = ArgumentMatchers.anyInt();
        departmentService.getDepartment(randomNumber);
        Mockito.verify(departmentDao).get(argCaptor.capture(), Department.class);
        Assertions.assertEquals(randomNumber, argCaptor.getValue());
    }

    @Test
    public void getAllDepartments() {
        departmentService.getAllDepartments();
        Mockito.verify(departmentDao).getAll(Department.class);
    }
}
