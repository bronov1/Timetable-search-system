package com.foxminded.university.dao;

import com.foxminded.university.entity.Floor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FloorDao extends AbstractDao<Floor>{

    private static final String GET_ALL_floorS = "FROM Floor";

    public FloorDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Floor> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Floor> floors = session.createQuery(GET_ALL_floorS, Floor.class).list();
            transaction.commit();
            return floors;
        }
    }

    @Override
    public void update(Floor floor, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            floor.setNumber((Integer) params[0]);
            floor.setBuildingId((Integer) params[1]);
            session.saveOrUpdate(floor);
            transaction.commit();
        }
    }

}
