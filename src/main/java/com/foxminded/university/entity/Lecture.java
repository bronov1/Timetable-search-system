package com.foxminded.university.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Lecture {

    private Subject subject;
    private Professor professor;
    private Group[] groups;
    private Date date;
    private Classroom classroom;

    public Lecture(Subject subject, Professor professor, Group[] groups, Date date, Classroom classroom) {
        this.subject = subject;
        this.professor = professor;
        this.groups = groups;
        this.date = date;
        this.classroom = classroom;
    }

    public Subject getSubject() {
        return subject;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Group[] getGroups() {
        return groups;
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

    public void setGroups(Group[] groups) {
        this.groups = groups;
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
        return subject.equals(lecture.subject) &&
                professor.equals(lecture.professor) &&
                Arrays.equals(groups, lecture.groups) &&
                date.equals(lecture.date) &&
                classroom.equals(lecture.classroom);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(subject, professor, date, classroom);
        result = 31 * result + Arrays.hashCode(groups);
        return result;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "subject=" + subject +
                ", professor=" + professor +
                ", groups=" + Arrays.toString(groups) +
                ", date=" + date +
                ", classroom=" + classroom +
                '}';
    }
}
