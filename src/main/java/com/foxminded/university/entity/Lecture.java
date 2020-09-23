package com.foxminded.university.entity;


import java.time.LocalDateTime;
import java.util.Objects;

public class Lecture {

    private int id;
    private int subjectId;
    private int professorId;
    private LocalDateTime date;
    private int classroomId;

    public Lecture(int subjectId, int professorId, LocalDateTime date, int classroomId) {
        this.subjectId = subjectId;
        this.professorId = professorId;
        this.date = date;
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

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return id == lecture.id &&
                subjectId == lecture.subjectId &&
                professorId == lecture.professorId &&
                classroomId == lecture.classroomId &&
                date.equals(lecture.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectId, professorId, date, classroomId);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", professorId=" + professorId +
                ", date=" + date +
                ", classroomId=" + classroomId +
                '}';
    }

}
