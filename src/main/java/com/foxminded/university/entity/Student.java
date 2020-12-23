package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(name = "groupId")
    private int groupId;

    public Student(String name, int groupId) {
        super(name);
        this.groupId = groupId;
    }

    public Student(){

    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return groupId == student.groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), super.getId(), groupId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + super.getId() +
                ", groupId=" + groupId +
                '}';
    }

}
