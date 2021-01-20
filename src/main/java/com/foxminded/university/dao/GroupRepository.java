package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GroupRepository extends CrudRepository<Group, Integer>  {

    @Query("SELECT g FROM Group g JOIN g.lectures l WHERE l.id = :lectureId")
    List<Group> getGroupsOnLecture(@Param("lectureId") int lectureId);

    @Query("SELECT l FROM Lecture l " +
            "JOIN l.groups g " +
            "WHERE g.id = :groupId AND l.date BETWEEN :startDate AND :finishDate")
    List<Lecture> getGroupPeriodLectures(@Param("groupId") int groupId,
                                         @Param("startDate") LocalDate startDate,
                                         @Param("finishDate") LocalDate finishDate);


}
