package com.foxminded.university.config;

import com.foxminded.university.service.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

@Configuration
@ComponentScan("com.foxminded.university")
public class SpringJdbcConfig {

    @Autowired
    FileReader fileReader;

    @Bean
    public DataSource dataSource() throws URISyntaxException, IOException {
        final String dbURL, dbUser, userPassword;
        FileInputStream dbProperties = new FileInputStream(String.valueOf(fileReader.getFilePath("db.properties")));
        Properties property = new Properties();
        property.load(dbProperties);
        dbURL = property.getProperty("db.url");
        dbUser = property.getProperty("db.login");
        userPassword = property.getProperty("db.password");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dbURL);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(userPassword);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws IOException, URISyntaxException {
        return new JdbcTemplate(dataSource());
    }

}
