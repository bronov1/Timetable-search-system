package com.foxminded.university.entity;

import java.util.Objects;

public class Stream {

    private int id;
    private String name;
    private int departmentId;

    public Stream(String name, int departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }

    public Stream() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Stream stream = (Stream) o;
        return id == stream.id &&
                departmentId == stream.departmentId &&
                name.equals(stream.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, departmentId);
    }

    @Override
    public String toString() {
        return "Stream{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

}
