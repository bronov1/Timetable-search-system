package com.foxminded.university.controllers;

import com.foxminded.university.controller.GroupController;
import com.foxminded.university.entity.Group;
import com.foxminded.university.service.StreamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.List;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class GroupControllerTest {

    @Mock
    GroupController groupController;
    @Mock
    Model model;
    @Mock
    StreamService streamService;
    @Mock
    List<Group> groups;
    @Captor
    ArgumentCaptor<List<Group>> groupListCaptor;
    @Captor
    ArgumentCaptor<StreamService> streamServiceCaptor;

    @Test
    public void showAll() {
        groupController.showAll(model);
        verify(model).addAttribute(groups);
        //Assertions.assertEquals(groups, groupListCaptor.getValue());
        verify(model).addAttribute(streamServiceCaptor.capture());
        Assertions.assertEquals(streamService, streamServiceCaptor.getValue());
    }
}
