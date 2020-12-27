package com.foxminded.university.dao;

import com.foxminded.university.entity.Building;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingDao implements Dao<Building> {

    private static final String GET_ALL_BUILDINGS = "FROM Building";

    private final SessionFactory sessionFactory;

    public BuildingDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Building get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Building building = session.get(Building.class, id);
            transaction.commit();
            return building;
        }
    }

    @Override
    public List<Building> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Building> buildings = session.createQuery(GET_ALL_BUILDINGS, Building.class).list();
            transaction.commit();
            return buildings;
        }
    }

    @Override
    public void save(Building building) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(building);
            transaction.commit();
        }
    }

    @Override
    public void update(Building building, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            building.setName((String) params[0]);
            building.setFloors((Integer) params[1]);
            session.saveOrUpdate(building);
            transaction.commit();
        }
    }

    @Override
    public void delete(Building building) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(building);
            transaction.commit();
        }
    }

}
