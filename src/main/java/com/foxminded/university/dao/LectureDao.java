package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureDao extends AbstractDao<Lecture> {

    private static final String GET_ALL_LECTURES_WITH_PROFESSOR = "FROM Lecture WHERE professorId = :id";

    private final LectureGroupDao lectureGroupDao;

    public LectureDao(SessionFactory sessionFactory, LectureGroupDao lectureGroupDao) {
        super(sessionFactory);
        this.lectureGroupDao = lectureGroupDao;
    }

    @Override
    public void delete(Lecture lecture) {
        lectureGroupDao.deleteLectureForGroups(lecture);
        super.delete(lecture);
    }

    public void deleteLecturesWithProfessor(Professor professor) {
        List<Lecture> lecturesWithProfessor = getAllLecturesWithProfessor(professor);
        for (Lecture lecture : lecturesWithProfessor) {
            delete(lecture);
        }
    }

    public List<Lecture> getAllLecturesWithProfessor(Professor professor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Lecture> query = session.createQuery(GET_ALL_LECTURES_WITH_PROFESSOR, Lecture.class);
            query.setParameter("id", professor.getId());
            List<Lecture> lecturesWithProfessor = query.list();
            transaction.commit();
            return lecturesWithProfessor;
        }
    }
}
