package com.foxminded.university.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.foxminded.university")
@PropertySource("classpath:db.properties")
public class SpringJDBCConfig {

    @Value("${db.url}")
    private String dbURL;
    @Value("${db.login}")
    private String dbUser;
    @Value("${db.password}")
    private String userPassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dbURL);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(userPassword);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate()  {
        return new JdbcTemplate(dataSource());
    }

}
