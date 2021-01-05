package com.foxminded.university.dao;

import com.foxminded.university.entity.Stream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StreamDao extends AbstractDao<Stream> {

    private static final String GET_ALL_STREAMS = "FROM Stream";

    public StreamDao(SessionFactory sessionFactory) {
        super(sessionFactory);
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
    public void update(Stream stream) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            stream.setName(stream.getName());
            stream.setDepartmentId(stream.getDepartmentId());
            session.saveOrUpdate(stream);
            transaction.commit();
        }
    }
}
