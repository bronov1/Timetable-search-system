package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDao implements Dao<Student> {

    private static final String DELETE_STUDENTS_FROM_GROUP = "DELETE Student WHERE groupId = :id";
    private static final String GET_ALL_STUDENTS = "FROM Student";

    private final SessionFactory sessionFactory;

    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            transaction.commit();
            return student;
        }
    }

    @Override
    public List<Student> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Student> students = session.createQuery(GET_ALL_STUDENTS, Student.class).list();
            transaction.commit();
            return students;
        }
    }

    @Override
    public void save(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
    }

    @Override
    public void update(Student student, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            student.setName((String) params[0]);
            student.setGroupId((Integer) params[1]);
            session.saveOrUpdate(student);
            transaction.commit();
        }
    }

    @Override
    public void delete(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        }
    }

    public void DeleteStudentsFromGroup(Group group) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(DELETE_STUDENTS_FROM_GROUP);
            query.setParameter("id", group.getId());
            query.executeUpdate();
            transaction.commit();
        }
    }
}
