package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;

@Repository
public class StudentDao extends AbstractDao<Student> {

    private static final String DELETE_STUDENTS_FROM_GROUP = "DELETE Student WHERE groupId = :id";

    public StudentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
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
