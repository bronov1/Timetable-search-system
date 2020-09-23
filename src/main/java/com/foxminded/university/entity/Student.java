package com.foxminded.university.entity;

import java.util.Objects;

public class Student extends Person {

    private int id;
    private int groupId;

    public Student(String name, int groupId) {
        super(name);
        this.groupId = groupId;
    }

    public Student(){

    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
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
        return id == student.id &&
                groupId == student.groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, groupId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", groupId=" + groupId +
                '}';
    }

}
