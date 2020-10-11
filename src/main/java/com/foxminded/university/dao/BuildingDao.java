package com.foxminded.university.dao;

import com.foxminded.university.entity.Building;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class BuildingDao implements Dao<Building> {

    private static final Logger logger = LoggerFactory.getLogger("BuildingDao");

    private static final String GET_BUILDING = "SELECT * FROM BUILDINGS WHERE ID = ?";
    private static final String GET_ALL_BUILDINGS = "SELECT * FROM BUILDINGS";
    private static final String SAVE_BUILDING = "INSERT INTO BUILDINGS (NAME, FLOORS) VALUES (?,?)";
    private static final String UPDATE_BUILDING = "UPDATE BUILDINGS SET (NAME, FLOORS)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_BUILDING = "DELETE FROM BUILDINGS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    public BuildingDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Building get(int id) {
        Building building = jdbcTemplate.queryForObject(GET_BUILDING, new Object[]{id}, new BeanPropertyRowMapper<>(Building.class));
        logger.info("Объект {} взят из базы", building.getClass());
        return building;
    }

    @Override
    public List<Building> getAll() {
        List<Building> buildings = jdbcTemplate.query(GET_ALL_BUILDINGS, new BeanPropertyRowMapper<>(Building.class));
        logger.info("Список обектов {} взят из базы", buildings.getClass());
        return buildings;
    }

    @Override
    public void save(Building building) {
        jdbcTemplate.update(SAVE_BUILDING, building.getName(), building.getFloors());
        logger.info("Объект {} сохранен в базу", building.getClass());
    }

    @Override
    public void update(Building building, Object[] params) {
        jdbcTemplate.update(UPDATE_BUILDING, params[0], params[1], building.getId());
        logger.info("Объект {} обновлен", building.getClass());
    }

    @Override
    public void delete(Building building) {
        jdbcTemplate.update(DELETE_BUILDING, building.getId());
        logger.info("Объект {} удален из базы", building.getClass());
    }

}
