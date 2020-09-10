package com.foxminded.university.entity;

public class Professor extends Person {

    private Department department;

    public Professor(String name) {
        super(name);
    }

    public Professor(String name, Department department) {
        super(name);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
