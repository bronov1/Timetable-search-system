package com.foxminded.university.dao;

import com.foxminded.university.entity.Stream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StreamDao implements Dao<Stream> {

    private static final String GET_ALL_STREAMS = "FROM Stream";

    private final SessionFactory sessionFactory;

    public StreamDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Stream get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Stream stream = session.get(Stream.class, id);
            transaction.commit();
            return stream;
        }
    }

    @Override
    public List<Stream> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Stream> streams = session.createQuery(GET_ALL_STREAMS, Stream.class).list();
            transaction.commit();
            return streams;
        }
    }

    @Override
    public void save(Stream stream) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(stream);
            transaction.commit();
        }
    }

    @Override
    public void update(Stream stream, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            stream.setName((String) params[0]);
            stream.setDepartmentId((Integer) params[1]);
            session.saveOrUpdate(stream);
            transaction.commit();
        }
    }

    @Override
    public void delete(Stream stream) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(stream);
            transaction.commit();
        }
    }
}
