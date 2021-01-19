package com.foxminded.university.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "professorId")
    private Professor professor;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "time")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;
    @ManyToOne
    @JoinColumn(name = "classroomId")
    private Classroom classroom;
    @ManyToMany()
    @JoinTable(name = "lecturegroups",
            joinColumns = @JoinColumn(name = "lectureId"),
            inverseJoinColumns = @JoinColumn(name = "groupId"))
    private List<Group> groups = new ArrayList<>();

    public Lecture(int id, Subject subject, Professor professor, LocalDate date, LocalTime time, Classroom classroom, List<Group> groups) {
        this.id = id;
        this.subject = subject;
        this.professor = professor;
        this.date = date;
        this.time = time;
        this.classroom = classroom;
        this.groups = groups;
    }

    public Lecture() {
    }

    public void addGroup(Group group) {
        groups.add(group);
        group.getLectures().add(this);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
        group.getLectures().remove(this);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public int getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public Professor getProfessor() {
        return professor;
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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(Subject subjectId) {
        this.subject = subjectId;
    }

    public void setProfessor(Professor professorId) {
        this.professor = professorId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setClassroom(Classroom classroomId) {
        this.classroom = classroomId;
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
                time.equals(lecture.time) &&
                classroom.equals(lecture.classroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, professor, date, time, classroom);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", subject=" + subject +
                ", professor=" + professor +
                ", date=" + date +
                ", time=" + time +
                ", classroom=" + classroom +
                '}';
    }

}
