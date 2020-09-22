package com.foxminded.university.dao;

import com.foxminded.university.entity.Professor;
import com.foxminded.university.entity.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StreamDao implements Dao<Stream> {

    private static final String GET_STREAM = "Select * from streams where id = ?";
    private static final String GET_ALL_STREAMS = "Select * from streams";
    private static final String SAVE_STREAM = "Insert into streams (name, department) values (?,?)";
    private static final String UPDATE_STREAM = "Update streams set (name, department)  = (?, ?) where id = ?";
    private static final String DELETE_STREAM = "Delete from streams where id = ?";

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
        jdbcTemplate.update(SAVE_STREAM, stream.getName(), stream.getDepartment());
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
