package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student extends Person {

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    public Student(String name, Group group) {
        super(name);
        this.group = group;
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

    public void setGroup(Group groupId) {
        this.group = groupId;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return group.equals(student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "group=" + group +
                ", name='" + name + '\'' +
                '}';
    }

}
