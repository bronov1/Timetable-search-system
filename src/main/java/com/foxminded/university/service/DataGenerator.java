package com.foxminded.university.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;
import java.nio.file.Path;

@Service
public class DataGenerator {

    private static final Logger logger = LoggerFactory.getLogger("DataGenerator");

    private final FileReader fileReader;
    private final ScriptRunner scriptRunner;

    public DataGenerator(FileReader fileReader, ScriptRunner scriptRunner) {
        this.fileReader = fileReader;
        this.scriptRunner = scriptRunner;
    }

    @PostConstruct
    public void createTables() throws URISyntaxException {
        Path createTablesPath = fileReader.getFilePath("createTables.sql");
        Path generateDataPath = fileReader.getFilePath("generate Data.sql");
        logger.info("Starting generate tables");
        scriptRunner.executeScript(createTablesPath);
        logger.info("Finished generate tables");
        logger.info("Starting generate initial data");
        scriptRunner.executeScript(generateDataPath);
        logger.info("Finished generate initial data");
    }
}
