package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lecturegroups")
public class LectureGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public LectureGroup(Lecture lecture, Group group) {
        this.lecture = lecture;
        this.group = group;
    }

    public LectureGroup() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public void setGroup(Group groupId) {
        this.group = groupId;
    }

    public int getId() {
        return id;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureGroup that = (LectureGroup) o;
        return id == that.id &&
                lecture.equals(that.lecture) &&
                group.equals(that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lecture, group);
    }

    @Override
    public String toString() {
        return "LectureGroup{" +
                "id=" + id +
                ", lecture=" + lecture +
                ", group=" + group +
                '}';
    }
}
