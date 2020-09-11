package com.foxminded.university.entity;

import java.util.Objects;

public class Student extends Person {

    private Group group;

    public Student(String name) {
        super(name);
    }

    public Student(String name, Group group) {
        super(name);
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
                '}';
    }
}
