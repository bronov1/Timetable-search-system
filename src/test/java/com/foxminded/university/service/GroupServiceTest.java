package com.foxminded.university.service;

import com.foxminded.university.dao.GroupRepository;
import com.foxminded.university.dao.LectureRepository;
import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class GroupServiceTest {

    @Mock
    Group group;
    @Mock
    Lecture lecture;
    @Mock
    GroupRepository groupRepository;
    @Mock
    LectureRepository lectureRepository;
    @Spy
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
        Mockito.verify(lectureRepository).findAllByGroupsAndLectureDateBetween(group, dateCaptor.capture(), dateCaptor.capture());
        Assertions.assertEquals(randomStartDate, dateCaptor.getValue());
        Assertions.assertEquals(randomFinishDate, dateCaptor.getValue());
    }

    @Test
    public void getAllGroups() {
        groupService.getAllGroups();
        Mockito.verify(groupRepository).findAll();
    }

    @Test
    public void getGroupsOnLecture() {
        groupService.getGroupsOnLecture(lecture);
        Mockito.verify(groupRepository).findAllByLectures(lecture);
    }

    @Test
    public void saveGroup() {
        groupService.saveGroup(group);
        Mockito.verify(groupRepository).save(group);
    }

    @Test
    public void getGroup() {
        int randomNumber = ArgumentMatchers.anyInt();
        groupService.getGroup(randomNumber);
        Mockito.verify(groupRepository).findById(intCaptor.capture());
        Assertions.assertEquals(randomNumber, intCaptor.getValue());
    }

    @Test
    public void updateGroup() {
        groupService.updateGroup(group);
        Mockito.verify(groupService).updateGroup(group);
    }

    @Test
    public void deleteGroup() {
        groupService.deleteGroup(group);
        Mockito.verify(groupRepository).delete(group);
    }
}
