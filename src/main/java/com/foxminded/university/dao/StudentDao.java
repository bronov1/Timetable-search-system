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
public class StudentDao extends AbstractDao<Student> {

    private static final String DELETE_STUDENTS_FROM_GROUP = "DELETE Student WHERE groupId = :id";
    private static final String GET_ALL_STUDENTS = "FROM Student";

    public StudentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
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
    public void update(Student student, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            student.setName((String) params[0]);
            student.setGroupId((Integer) params[1]);
            session.saveOrUpdate(student);
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
