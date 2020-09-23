package com.foxminded.university;

import com.foxminded.university.config.SpringJdbcConfig;
import com.foxminded.university.service.FileReader;
import com.foxminded.university.service.ScriptRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        Path scriptPath = context.getBean(FileReader.class).getFilePath("runDB.sql");
        context.getBean(ScriptRunner.class).executeScript(scriptPath);
    }
}
