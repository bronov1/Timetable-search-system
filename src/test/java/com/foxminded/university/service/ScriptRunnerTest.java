package com.foxminded.university.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@ExtendWith(MockitoExtension.class)
public class ScriptRunnerTest {

    @Mock
    ScriptRunner scriptRunner;
    @Mock
    Path path;

    @Captor
    ArgumentCaptor argCaptor;

    @Test
    void executeScript_DefaultInput_DefaultOutput() throws IOException {
        scriptRunner.executeScript(path);
        Mockito.verify(scriptRunner).executeScript((Path) argCaptor.capture());
        Assertions.assertEquals(path, argCaptor.getValue());
    }
}
