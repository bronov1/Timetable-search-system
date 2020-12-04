package com.foxminded.university.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Service
public class DataGenerator {

    private static final Logger logger = LoggerFactory.getLogger("DataGenerator");

    private final DataSource dataSource;

    public DataGenerator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void createTables() {
        logger.info("Starting generate tables");
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.setScripts(new ClassPathResource("createTables.sql"), new ClassPathResource("generate Data.sql"));
        DatabasePopulatorUtils.execute(resourceDatabasePopulator,dataSource);
        logger.info("Finished generate tables");
    }
}
