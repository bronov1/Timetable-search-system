package com.foxminded.university.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return department.equals(professor.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "department=" + department +
                '}';
    }
}
