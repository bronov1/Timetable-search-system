package com.foxminded.university.entity;

import java.util.Objects;

public class Professor extends Person {

    private int id;
    private Department department;

    public Professor(String name, Department department) {
        super(name);
        this.department = department;
    }

    public Professor() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
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
        return id == professor.id &&
                department.equals(professor.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, department);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", department=" + department +
                '}';
    }
}
