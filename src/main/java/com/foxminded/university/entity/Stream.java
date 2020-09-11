package com.foxminded.university.entity;

import java.util.Objects;

public class Stream {

    private String name;
    private Department department;

    public Stream(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stream stream = (Stream) o;
        return name.equals(stream.name) &&
                department.equals(stream.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department);
    }

    @Override
    public String toString() {
        return "Stream{" +
                "name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
