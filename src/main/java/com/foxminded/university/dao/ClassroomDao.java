package com.foxminded.university.dao;

import com.foxminded.university.entity.Classroom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassroomDao implements Dao<Classroom>{

    private static final String GET_ALL_CLASSROOMS = "FROM Classroom";

    private final SessionFactory sessionFactory;

    public ClassroomDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Classroom get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Classroom classroom = session.get(Classroom.class, id);
            transaction.commit();
            return classroom;
        }
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
    public void save(Classroom classroom) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(classroom);
            transaction.commit();
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

    @Override
    public void delete(Classroom classroom) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(classroom);
            transaction.commit();
        }
    }
}
