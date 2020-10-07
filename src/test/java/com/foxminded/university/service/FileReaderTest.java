package com.foxminded.university.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class FileReaderTest {

    @Spy
    private final FileReader fileReader;
    @Mock
    FileReader mockFileReader;

    public FileReaderTest() {
        this.fileReader = new FileReader();
    }

    @Test
    void getFilePath_DefaultUsage_InternalMethodCalled() throws URISyntaxException {
        mockFileReader.getFilePath(anyString());
        Mockito.verify(mockFileReader).getFilePath(anyString());
    }

    @Test
    void getFilePath_Null_IllegalArgumentExceptionThrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            fileReader.getFilePath(null);
        });
    }
}
