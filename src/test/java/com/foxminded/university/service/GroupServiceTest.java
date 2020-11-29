package com.foxminded.university.service;

import com.foxminded.university.dao.GroupDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class GroupServiceTest {

    @Mock
    GroupDao groupDao;
    @InjectMocks
    GroupService groupService;
    @Captor
    ArgumentCaptor<Integer> intCaptor;
    @Captor
    ArgumentCaptor<LocalDate> dateCaptor;

    @Test
    public void getGroupMonthLectures_DefaultInput_DefaultOutput() {
        int randomNumber = ArgumentMatchers.anyInt();
        LocalDate randomStartDate = ArgumentMatchers.any(LocalDate.class);
        LocalDate randomFinishDate = ArgumentMatchers.any(LocalDate.class);
        groupService.getGroupSchedule(randomNumber, randomStartDate, randomFinishDate);
        Mockito.verify(groupDao).getGroupPeriodLectures(intCaptor.capture(), dateCaptor.capture(), dateCaptor.capture());
        Assertions.assertEquals(randomNumber, intCaptor.getValue());
        Assertions.assertEquals(randomStartDate, dateCaptor.getValue());
        Assertions.assertEquals(randomFinishDate, dateCaptor.getValue());
    }

    @Test
    public void getAllGroups() {
        groupService.getAllGroups();
        Mockito.verify(groupDao).getAll();
    }

    @Test
    public void getGroupsOnLecture() {
        int randomNumber = ArgumentMatchers.anyInt();
        groupService.getGroupsOnLecture(randomNumber);
        Mockito.verify(groupDao).getGroupsOnLecture(intCaptor.capture());
        Assertions.assertEquals(randomNumber, intCaptor.getValue());
    }
}
