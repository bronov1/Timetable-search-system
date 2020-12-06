package com.foxminded.university.service;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GroupService {

    private static final Logger logger = LoggerFactory.getLogger("GroupService");

    private final GroupDao groupDao;

    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public List<Lecture> getGroupSchedule(int groupId, LocalDate startDate, LocalDate finishDate){
        List<Lecture> lectures = groupDao.getGroupPeriodLectures(groupId, startDate, finishDate);
        logger.info("Got schedule for group {} for dates {} - {}", groupDao.get(groupId), startDate, finishDate);
        return lectures;
    }

    public List<Group> getAllGroups() {
        return groupDao.getAll();
    }

    public List<Group> getGroupsOnLecture(int lectureId) {
        List<Group> groups = groupDao.getGroupsOnLecture(lectureId);
        logger.info("Got groups on lecture with id {} form Database", lectureId);
        return groups;
    }

    public void saveGroup(Group group) {
        groupDao.save(group);
        logger.info("Saved new group");
    }

    public Group getGroup(int id) {
        Group group = groupDao.get(id);
        logger.info("Got group with id - {}", id);
        return group;
    }

    public void updateGroup(Group group) {
        Object[] parameters = new Object[]{group.getName(), group.getStreamId()};
        groupDao.update(group, parameters);
        logger.info("Updated group with id - {}", group.getId());
    }

    public void deleteGroup(Group group) {
        groupDao.delete(group);
        logger.info("Deleted group with id - {}", group.getId());
    }
}
