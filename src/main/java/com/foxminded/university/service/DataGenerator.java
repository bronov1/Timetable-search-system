package com.foxminded.university.service;

import com.foxminded.university.config.HibernateUtil;
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

    public DataGenerator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void createTables() {
        Student student1 = new Student("Loh", 2);
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects

            logger.info("Starting generate tables");
            ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
            resourceDatabasePopulator.setScripts(new ClassPathResource("createTables.sql"), new ClassPathResource("generate Data.sql"));
            DatabasePopulatorUtils.execute(resourceDatabasePopulator,dataSource);
            logger.info("Finished generate tables");

            session.save(student1);
            // commit transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
