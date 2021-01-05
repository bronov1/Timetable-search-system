package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class GroupDao extends AbstractDao<Group> {

    private static final String GET_ALL_GROUPS = "FROM Group";
    private static final String GET_ALL_GROUPS_FOR_LECTURE = "SELECT g FROM Group g, LectureGroup lg " +
            "WHERE g.id = lg.groupId AND lg.lectureId = :lectureId";
    private static final String GET_GROUP_PERIOD_SCHEDULE = "SELECT l " +
            "FROM Group g, LectureGroup lg, Lecture l " +
            "WHERE g.id = lg.groupId AND lg.lectureId = l.id " +
            "AND g.id = :groupId AND l.date BETWEEN :startDate AND :finishDate";

    private final StudentDao studentDao;
    private final LectureGroupDao lectureGroupDao;

    public GroupDao(StudentDao studentDao, LectureGroupDao lectureGroupDao, SessionFactory sessionFactory) {
        super(sessionFactory);
        this.studentDao = studentDao;
        this.lectureGroupDao = lectureGroupDao;
    }

    @Override
    public List<Group> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Group> groups = session.createQuery(GET_ALL_GROUPS, Group.class).list();
            transaction.commit();
            return groups;
        }
    }

    @Override
    public void update(Group group) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            group.setName(group.getName());
            group.setStreamId(group.getStreamId());
            session.saveOrUpdate(group);
            transaction.commit();
        }
    }

    @Override
    public void delete(Group group) {
        studentDao.DeleteStudentsFromGroup(group);
        lectureGroupDao.DeleteGroupFromLecture(group);
        super.delete(group);
    }

    public List<Lecture> getGroupPeriodLectures(int groupId, LocalDate startDate, LocalDate finishDate) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Lecture> query = session.createQuery(GET_GROUP_PERIOD_SCHEDULE, Lecture.class);
            query.setParameter("groupId", groupId);
            query.setParameter("startDate", startDate);
            query.setParameter("finishDate", finishDate);
            List<Lecture> groupPeriodLectures = query.list();
            transaction.commit();
            return groupPeriodLectures;
        }
    }

    public List<Group> getGroupsOnLecture(int lectureId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Group> query = session.createQuery(GET_ALL_GROUPS_FOR_LECTURE, Group.class);
            query.setParameter("lectureId", lectureId);
            List<Group> groupsOnLecture = query.list();
            transaction.commit();
            return groupsOnLecture;
        }
    }
}
