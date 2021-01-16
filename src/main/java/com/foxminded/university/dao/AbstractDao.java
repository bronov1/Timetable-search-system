package com.foxminded.university.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class AbstractDao<T> {

    protected final SessionFactory sessionFactory;

    protected AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<T> findAll(Class<T> tClass) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String getAll = "FROM " + tClass.getSimpleName();
            List<T> tList = session.createQuery(getAll, tClass).list();
            transaction.commit();
            return tList;
        }
    }

    public void save(T t) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            transaction.commit();
        }
    }

    public T findById(int id, Class<T> tClass) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            T t = session.get(tClass, id);
            transaction.commit();
            return t;
        }
    }

    public void delete(T t) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
        }
    }
}
