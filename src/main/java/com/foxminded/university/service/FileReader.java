package com.foxminded.university.service;

import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileReader {

    public Path getFilePath(String fileName) throws URISyntaxException {
        try {
            return Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("There isn't such file in called root");
        }
    }

}