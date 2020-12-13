package com.foxminded.university.controllers;

import com.foxminded.university.controller.GroupController;
import com.foxminded.university.entity.Group;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StreamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class GroupControllerTest {

    @InjectMocks
    GroupController groupController;
    @Mock
    StreamService streamService;
    @Mock
    GroupService groupService;
    @Mock
    Model model;
    @Mock
    Group group;

    @Test
    public void showAll() {
        groupController.showAll(model);
        verify(groupService).getAllGroups();
    }

    @Test
    public void showAddingForm() {
        groupController.showAddingForm(group, model);
        verify(streamService).getAllStreams();
    }

    @Test
    public void saveNewGroup() {
        groupController.saveNewGroup(group);
        verify(groupService).saveGroup(group);
    }

    @Test
    public void edit() {
        groupController.edit(anyInt(), model);
        verify(groupService).getGroup(anyInt());
        verify(streamService).getAllStreams();
    }

    @Test
    public void updateGroup() {
        groupController.updateGroup(group);
        verify(groupService).updateGroup(group);
    }

    @Test
    public void delete() {
        groupController.delete(group, anyInt());
        verify(group).setId(anyInt());
        verify(groupService).deleteGroup(group);
    }


}
