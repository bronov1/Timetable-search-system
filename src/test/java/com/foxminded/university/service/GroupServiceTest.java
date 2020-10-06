package com.foxminded.university.service;

import com.foxminded.university.dao.GroupDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class GroupServiceTest {

    @Mock
    GroupDao groupDao;
    @InjectMocks
    GroupService groupService;

    @Test
    public void getGroupMonthLectures_DefaultInput_DefaultOutput() {
        LocalDate startDate = LocalDate.of(2020, 10, 7);
        LocalDate finishDate = LocalDate.of(2020, 10, 14);
        groupService.getGroupMonthLectures(1, startDate, finishDate);
        Mockito.verify(groupDao).getGroupMonthLectures(1, startDate, finishDate);
    }
}
