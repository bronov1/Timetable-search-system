package com.foxminded.university.dao;

import com.foxminded.university.entity.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingDao implements Dao<Building> {

    private static final String GET_BUILDING = "Select * from buildings where id = ?";
    private static final String GET_ALL_BUILDINGS = "Select * from buildings";
    private static final String SAVE_BUILDING = "Insert into buildings (name, floors) values (?,?)";
    private static final String UPDATE_BUILDING = "Update buildings set (name, floors)  = (?, ?) where id = ?";
    private static final String DELETE_BUILDING = "Delete from buildings where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Building get(int id) {
        return jdbcTemplate.queryForObject(GET_BUILDING, new Object[]{id}, new BeanPropertyRowMapper<>(Building.class));
    }

    @Override
    public List<Building> getAll() {
        return jdbcTemplate.query(GET_ALL_BUILDINGS, new BeanPropertyRowMapper<>(Building.class));
    }

    @Override
    public void save(Building building) {
        jdbcTemplate.update(SAVE_BUILDING, building.getName(), building.getFloors());
    }

    @Override
    public void update(Building building, Object[] params) {
        jdbcTemplate.update(UPDATE_BUILDING, params[0], params[1], building.getId());
    }

    @Override
    public void delete(Building building) {
        jdbcTemplate.update(DELETE_BUILDING, building.getId());
    }
}
