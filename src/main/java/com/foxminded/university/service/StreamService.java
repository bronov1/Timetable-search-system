package com.foxminded.university.service;

import com.foxminded.university.dao.StreamDao;
import com.foxminded.university.entity.Stream;
import org.springframework.stereotype.Service;

@Service
public class StreamService {

    private final StreamDao streamDao;

    public StreamService(StreamDao streamDao) {
        this.streamDao = streamDao;
    }

    public Stream getStream(int id) {
        return streamDao.get(id);
    }
}
