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
    @Column(name = "lectureId")
    private int lectureId;
    @Column(name = "groupId")
    private int groupId;

    public LectureGroup(int lectureId, int groupId) {
        this.lectureId = lectureId;
        this.groupId = groupId;
    }

    public LectureGroup() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public int getLectureId() {
        return lectureId;
    }

    public int getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureGroup that = (LectureGroup) o;
        return id == that.id &&
                lectureId == that.lectureId &&
                groupId == that.groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lectureId, groupId);
    }

    @Override
    public String toString() {
        return "LectureGroup{" +
                "id=" + id +
                ", lectureId=" + lectureId +
                ", groupId=" + groupId +
                '}';
    }
}
