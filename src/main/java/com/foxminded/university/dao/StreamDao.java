package com.foxminded.university.dao;

import com.foxminded.university.entity.Professor;
import com.foxminded.university.entity.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StreamDao implements Dao<Stream> {

    private static final String GET_STREAM = "SELECT * FROM STREAMS WHERE ID = ?";
    private static final String GET_ALL_STREAMS = "SELECT * FROM STREAMS";
    private static final String SAVE_STREAM = "INSERT INTO STREAMS (NAME, DEPARTMENTID) VALUES (?,?)";
    private static final String UPDATE_STREAM = "UPDATE STREAMS SET (NAME, DEPARTMENTID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_STREAM = "DELETE FROM STREAMS WHERE ID = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Stream get(int id) {
        return jdbcTemplate.queryForObject(GET_STREAM, new Object[]{id}, new BeanPropertyRowMapper<>(Stream.class));
    }

    @Override
    public List<Stream> getAll() {
        return jdbcTemplate.query(GET_ALL_STREAMS, new BeanPropertyRowMapper<>(Stream.class));
    }

    @Override
    public void save(Stream stream) {
        jdbcTemplate.update(SAVE_STREAM, stream.getName(), stream.getDepartmentId());
    }

    @Override
    public void update(Stream stream, Object[] params) {
        jdbcTemplate.update(UPDATE_STREAM, params[0], params[1], stream.getId());
    }

    @Override
    public void delete(Stream stream) {
            jdbcTemplate.update(DELETE_STREAM, stream.getId());
    }
}
