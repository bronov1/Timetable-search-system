package com.foxminded.university.entity;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Lecture {

    private int id;
    private int subjectId;
    private int professorId;
    private LocalDate date;
    private LocalTime time;
    private int classroomId;

    public Lecture(int subjectId, int professorId, LocalDate date, LocalTime time, int classroomId) {
        this.subjectId = subjectId;
        this.professorId = professorId;
        this.date = date;
        this.time = time;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
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
                date.equals(lecture.date) &&
                time.equals(lecture.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectId, professorId, date, time, classroomId);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", professorId=" + professorId +
                ", date=" + date +
                ", time=" + time +
                ", classroomId=" + classroomId +
                '}';
    }

}
