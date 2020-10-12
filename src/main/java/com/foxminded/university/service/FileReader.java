package com.foxminded.university.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileReader {

    private static final Logger logger = LoggerFactory.getLogger("FileReader");

    public Path getFilePath(String fileName) throws URISyntaxException {
        try {
            return Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        } catch (NullPointerException e) {
            logger.error("Didn't find file in called root", e);
            throw new IllegalArgumentException("There isn't such file in called root");
        }
    }

}