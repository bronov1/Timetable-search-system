package com.foxminded.university.config;

import com.foxminded.university.entity.*;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

@org.springframework.context.annotation.Configuration
@PropertySource("classpath:db.properties")
public class HibernateConfig {

    @Value("${db.url}")
    private String dbURL;
    @Value("${db.login}")
    private String dbUser;
    @Value("${db.password}")
    private String userPassword;
    @Value("${db.driver}")
    private String dbDriver;
    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateAuto;
    @Value("${hibernate.show.sql}")
    private String hibernateShowSqlStatus;

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
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbURL);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(userPassword);
        return dataSource;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.hbm2ddl.auto", hibernateAuto);
        properties.put("hibernate.show_sql", hibernateShowSqlStatus);
        return properties;
    }

    @Bean
    public Configuration configuration() {
        return new Configuration();
    }
}
