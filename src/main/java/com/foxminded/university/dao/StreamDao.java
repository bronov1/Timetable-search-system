package com.foxminded.university.dao;

import com.foxminded.university.entity.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StreamDao implements Dao<Stream> {

    private static final Logger logger = LoggerFactory.getLogger("StreamDao");

    private static final String GET_STREAM = "SELECT * FROM STREAMS WHERE ID = ?";
    private static final String GET_ALL_STREAMS = "SELECT * FROM STREAMS";
    private static final String SAVE_STREAM = "INSERT INTO STREAMS (NAME, DEPARTMENTID) VALUES (?,?)";
    private static final String UPDATE_STREAM = "UPDATE STREAMS SET (NAME, DEPARTMENTID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_STREAM = "DELETE FROM STREAMS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    public StreamDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Stream get(int id) {
        Stream stream = jdbcTemplate.queryForObject(GET_STREAM, new Object[]{id}, new BeanPropertyRowMapper<>(Stream.class));
        logger.info("Объект {} взят из базы", stream.getClass());
        return stream;
    }

    @Override
    public List<Stream> getAll() {
        List<Stream> streams = jdbcTemplate.query(GET_ALL_STREAMS, new BeanPropertyRowMapper<>(Stream.class));
        logger.info("Список обектов {} взят из базы", streams.getClass());
        return streams;
    }

    @Override
    public void save(Stream stream) {
        jdbcTemplate.update(SAVE_STREAM, stream.getName(), stream.getDepartmentId());
        logger.info("Объект {} сохранен в базу", stream.getClass());
    }

    @Override
    public void update(Stream stream, Object[] params) {
        jdbcTemplate.update(UPDATE_STREAM, params[0], params[1], stream.getId());
        logger.info("Объект {} обновлен", stream.getClass());
    }

    @Override
    public void delete(Stream stream) {
            jdbcTemplate.update(DELETE_STREAM, stream.getId());
        logger.info("Объект {} удален из базы", stream.getClass());
    }
}
