package com.foxminded.university.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ScriptRunner {

    private final JdbcTemplate jdbcTemplate;

    public ScriptRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeScript(Path scriptPath) throws IOException {
        String scriptString = new String(Files.readAllBytes(scriptPath));
        jdbcTemplate.execute(scriptString);
    }

}
