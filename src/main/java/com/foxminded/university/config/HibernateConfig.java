package com.foxminded.university.config;

import com.foxminded.university.entity.*;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.util.Properties;

@org.springframework.context.annotation.Configuration
@ComponentScan("com.foxminded.university")
public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory() {
        Configuration configuration = configuration();
        addAnnotatedClasses(configuration);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySetting(Environment.DATASOURCE, dataSource()).
                applySettings(hibernateProperties()).
                build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private void addAnnotatedClasses(Configuration configuration) {
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Building.class);
        configuration.addAnnotatedClass(Classroom.class);
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Floor.class);
        configuration.addAnnotatedClass(Group.class);
        configuration.addAnnotatedClass(Lecture.class);
        configuration.addAnnotatedClass(LectureGroup.class);
        configuration.addAnnotatedClass(Professor.class);
        configuration.addAnnotatedClass(Stream.class);
        configuration.addAnnotatedClass(Subject.class);
    }

    @Bean
    public static DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/university");
        dataSource.setUsername("maintainer");
        dataSource.setPassword("12345678");
        return dataSource;
    }

    @Bean
    public static Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL92Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql", "true");
        return properties;
    }

    @Bean
    public Configuration configuration() {
        return new Configuration();
    }
}
