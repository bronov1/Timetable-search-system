package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ProfessorDao extends AbstractDao<Professor>{

    private static final String GET_ALL_PROFESSORS = "FROM Professor ";
    private static final String GET_PROFESSOR_PERIOD_SCHEDULE = "SELECT * FROM LECTURES " +
            "WHERE PROFESSORID = ? AND DATE BETWEEN ? AND ?";

    private final LectureDao lectureDao;

    public ProfessorDao(SessionFactory sessionFactory, LectureDao lectureDao) {
        super(sessionFactory);
        this.lectureDao = lectureDao;
    }

    @Override
    public List<Professor> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Professor> professors = session.createQuery(GET_ALL_PROFESSORS, Professor.class).list();
            transaction.commit();
            return professors;
        }
    }

    @Override
    public void update(Professor professors, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            professors.setName((String) params[0]);
            professors.setDepartmentId((Integer) params[1]);
            session.saveOrUpdate(professors);
            transaction.commit();
        }
    }

    @Override
    public void delete(Professor professor) {
        lectureDao.DeleteLecturesWithProfessor(professor);
        super.delete(professor);
    }

    //TODO: Fix this method
    public List<Lecture> getProfessorPeriodLectures(int professorId, LocalDate startDate, LocalDate finishDate) {
        return null;
    }
}
