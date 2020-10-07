package com.foxminded.university.service;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.entity.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GroupService {

    private final GroupDao groupDao;

    @Autowired
    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public List<Lecture> getGroupSchedule(int groupId, LocalDate startDate, LocalDate finishDate){
        return groupDao.getGroupPeriodLectures(groupId, startDate, finishDate);
    }
}
