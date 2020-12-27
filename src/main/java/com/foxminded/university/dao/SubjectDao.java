package com.foxminded.university.dao;


import com.foxminded.university.entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDao implements Dao<Subject> {

    private static final String GET_ALL_SUBJECTS = "FROM Subject";

    private final SessionFactory sessionFactory;

    public SubjectDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Subject get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Subject subject = session.get(Subject.class, id);
            transaction.commit();
            return subject;
        }
    }

    @Override
    public List<Subject> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Subject> subjects = session.createQuery(GET_ALL_SUBJECTS, Subject.class).list();
            transaction.commit();
            return subjects;
        }
    }

    @Override
    public void save(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(subject);
            transaction.commit();
        }
    }

    @Override
    public void update(Subject subject, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            subject.setName((String) params[0]);
            session.saveOrUpdate(subject);
            transaction.commit();
        }
    }

    @Override
    public void delete(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(subject);
            transaction.commit();
        }
    }
}

