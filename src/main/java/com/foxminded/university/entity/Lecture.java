package com.foxminded.university.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "subjectId")
    private int subjectId;
    @Column(name = "professorId")
    private int professorId;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "time")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;
    @Column(name = "classroomId")
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

    public int getSubjectId() {
        return subjectId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDateString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        return date.format(formatter);
    }

    public LocalDate setDateFromString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        return LocalDate.parse(dateString, formatter);
    }

    public LocalTime getTime() {
        return time;
    }

    public int getClassroomId() {
        return classroomId;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
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
