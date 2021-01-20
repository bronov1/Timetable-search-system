package com.foxminded.university.service;

import com.foxminded.university.dao.StreamRepository;
import com.foxminded.university.entity.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamService {

    private static final Logger logger = LoggerFactory.getLogger("StreamService");

    private final StreamRepository streamRepository;

    public StreamService(StreamRepository streamRepository) {
        this.streamRepository = streamRepository;
    }

    public Stream getStream(int id) {
        Optional<Stream> optionalStream = streamRepository.findById(id);
        logger.info("Got stream with {} form Database", id);
        return optionalStream.get();
    }

    public Iterable<Stream> getAllStreams() {
        Iterable<Stream> streams = streamRepository.findAll();
        logger.info("Got all streams from Database");
        return streams;
    }
}
