package com.foxminded.university.config;

import com.foxminded.university.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@org.springframework.context.annotation.Configuration
@ComponentScan("com.foxminded.university")
public class HibernateConfig {

    @Bean
    public Session session() {
        return sessionFactory().openSession();
    }

    @Bean
    public SessionFactory sessionFactory() {
        Configuration configuration = configuration();
        configuration.addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    @Bean
    public Properties properties() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://127.0.0.1:5432/university");
        properties.put(Environment.USER, "maintainer");
        properties.put(Environment.PASS, "12345678");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL92Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
        return properties;
    }

    @Bean
    public Configuration configuration() {
        Configuration configuration = new Configuration();
        configuration.setProperties(properties());
        return configuration;
    }
}
