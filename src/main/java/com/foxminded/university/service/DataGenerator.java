package com.foxminded.university.service;

import com.foxminded.university.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    private final Session session;

    public DataGenerator(DataSource dataSource, Session session) {
        this.dataSource = dataSource;
        this.session = session;
    }

    @PostConstruct
    public void createTables() {
        Student student = new Student("abf", 2);
        Transaction transaction = session.beginTransaction();
        logger.info("Starting generate tables");
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.setScripts(new ClassPathResource("createTables.sql"), new ClassPathResource("generate Data.sql"));
        DatabasePopulatorUtils.execute(resourceDatabasePopulator, dataSource);
        logger.info("Finished generate tables");
        session.save(student);
        transaction.commit();
    }
}
