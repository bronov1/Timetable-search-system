package com.foxminded.university.dao;

import com.foxminded.university.entity.Classroom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassroomDao extends AbstractDao<Classroom>{

    private static final String GET_ALL_CLASSROOMS = "FROM Classroom";

    public ClassroomDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Classroom> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Classroom> classrooms = session.createQuery(GET_ALL_CLASSROOMS, Classroom.class).list();
            transaction.commit();
            return classrooms;
        }
    }

    @Override
    public void update(Classroom classroom, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            classroom.setNumber((Integer) params[0]);
            classroom.setFloorId((Integer) params[1]);
            session.saveOrUpdate(classroom);
            transaction.commit();
        }
    }
}
