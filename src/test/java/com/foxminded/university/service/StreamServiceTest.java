package com.foxminded.university.service;

import com.foxminded.university.dao.StreamRepository;
import com.foxminded.university.entity.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StreamServiceTest {

    @Mock
    StreamRepository streamRepository;
    @InjectMocks
    StreamService streamService;
    @Captor
    ArgumentCaptor<Integer> argCaptor;

    @Test
    public void getStream() {
        int randomNumber = ArgumentMatchers.anyInt();
        streamService.getStream(randomNumber);
        Mockito.verify(streamRepository).findById(argCaptor.capture());
        Assertions.assertEquals(randomNumber, argCaptor.getValue());
    }

    @Test
    public void getAllStreams() {
        streamService.getAllStreams();
        Mockito.verify(streamRepository).findAll();
    }
}
