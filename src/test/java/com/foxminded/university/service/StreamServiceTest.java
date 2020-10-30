package com.foxminded.university.service;

import com.foxminded.university.dao.StreamDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StreamServiceTest {

    @Mock
    StreamDao streamDao;
    @InjectMocks
    StreamService streamService;

    @Test
    public void getStream() {
        streamService.getStream(1);
        Mockito.verify(streamDao).get(1);
    }
}
