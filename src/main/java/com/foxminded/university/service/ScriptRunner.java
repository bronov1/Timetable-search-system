package com.foxminded.university.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ScriptRunner {

    private static final Logger logger = LoggerFactory.getLogger("FileReader");

    private final JdbcTemplate jdbcTemplate;

    public ScriptRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeScript(Path scriptPath) {
        String scriptString;
        try {
            scriptString = new String(Files.readAllBytes(scriptPath));
        } catch (IOException e) {
            logger.error("Some problem with input/output operations", e);
            throw new IllegalArgumentException();
        }
        jdbcTemplate.execute(scriptString);
    }

}
