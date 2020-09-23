package com.foxminded.university.entity;

import java.util.Objects;

public class Professor extends Person {

    private int id;
    private int departmentId;

    public Professor(String name, int departmentId) {
        super(name);
        this.departmentId = departmentId;
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

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return id == professor.id &&
                departmentId == professor.departmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, departmentId);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", name='" + name + '\'' +
                '}';
    }

}
