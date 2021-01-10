package com.foxminded.university;

import com.foxminded.university.config.HibernateConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX,
                pattern = "com.foxminded.university.config.*")})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HibernateConfig.class, args);
    }
}
