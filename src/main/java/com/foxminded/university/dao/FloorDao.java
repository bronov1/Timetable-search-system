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
    public void update(Floor floor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            floor.setNumber(floor.getNumber());
            floor.setBuildingId(floor.getBuildingId());
            session.saveOrUpdate(floor);
            transaction.commit();
        }
    }

}
