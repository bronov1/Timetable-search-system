package com.foxminded.university.entity;

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
}
