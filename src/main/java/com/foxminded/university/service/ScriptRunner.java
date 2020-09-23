package com.foxminded.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ScriptRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void executeScript(Path scriptPath) throws IOException {
        String scriptString = new String(Files.readAllBytes(scriptPath));
        jdbcTemplate.execute(scriptString);
    }

}
