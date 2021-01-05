package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ProfessorDao extends AbstractDao<Professor> {

    private static final String GET_PROFESSOR_PERIOD_SCHEDULE = "SELECT l FROM Lecture l " +
            "WHERE l.professorId = :professorId AND l.date BETWEEN :startDate AND :finishDate";

    private final LectureDao lectureDao;

    public ProfessorDao(SessionFactory sessionFactory, LectureDao lectureDao) {
        super(sessionFactory);
        this.lectureDao = lectureDao;
    }

    @Override
    public void delete(Professor professor) {
        lectureDao.DeleteLecturesWithProfessor(professor);
        super.delete(professor);
    }

    public List<Lecture> getProfessorPeriodLectures(int professorId, LocalDate startDate, LocalDate finishDate) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Lecture> query = session.createQuery(GET_PROFESSOR_PERIOD_SCHEDULE, Lecture.class);
            query.setParameter("professorId", professorId);
            query.setParameter("startDate", startDate);
            query.setParameter("finishDate", finishDate);
            List<Lecture> professorPeriodLectures = query.list();
            transaction.commit();
            return professorPeriodLectures;
        }
    }

}
