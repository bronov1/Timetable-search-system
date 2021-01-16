package com.foxminded.university.service;

import com.foxminded.university.dao.StreamDao;
import com.foxminded.university.entity.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamService {

    private static final Logger logger = LoggerFactory.getLogger("StreamService");

    private final StreamDao streamDao;

    public StreamService(StreamDao streamDao) {
        this.streamDao = streamDao;
    }

    public Stream getStream(int id) {
        Stream stream = streamDao.findById(id, Stream.class);
        logger.info("Got stream with {} form Database", id);
        return stream;
    }

    public List<Stream> getAllStreams() {
        List<Stream> streams = streamDao.findAll(Stream.class);
        logger.info("Got all streams from Database");
        return streams;
    }
}
