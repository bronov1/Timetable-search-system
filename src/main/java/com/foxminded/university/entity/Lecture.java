package com.foxminded.university.entity;

import java.util.Date;
import java.util.Objects;

public class Lecture {

    private int id;
    private Subject subject;
    private Professor professor;
    private Date date;
    private Classroom classroom;

    public Lecture(Subject subject, Professor professor, Date date, Classroom classroom) {
        this.subject = subject;
        this.professor = professor;
        this.date = date;
        this.classroom = classroom;
    }

    public Lecture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Date getDate() {
        return date;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return id == lecture.id &&
                subject.equals(lecture.subject) &&
                professor.equals(lecture.professor) &&
                date.equals(lecture.date) &&
                classroom.equals(lecture.classroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, professor, date, classroom);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", subject=" + subject +
                ", professor=" + professor +
                ", date=" + date +
                ", classroom=" + classroom +
                '}';
    }
}
