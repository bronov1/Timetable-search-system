package com.foxminded.university.entity;


import java.util.Objects;

public class Lecture {

    private int id;
    private int subjectId;
    private int professorId;
    private int dateId;
    private int classroomId;

    public Lecture(int subjectId, int professorId, int dateId, int classroomId) {
        this.subjectId = subjectId;
        this.professorId = professorId;
        this.dateId = dateId;
        this.classroomId = classroomId;
    }

    public Lecture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public int getDateId() {
        return dateId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return id == lecture.id &&
                subjectId == lecture.subjectId &&
                professorId == lecture.professorId &&
                dateId == lecture.dateId &&
                classroomId == lecture.classroomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectId, professorId, dateId, classroomId);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", professorId=" + professorId +
                ", dateId=" + dateId +
                ", classroomId=" + classroomId +
                '}';
    }

}
