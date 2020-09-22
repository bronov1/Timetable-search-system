package com.foxminded.university.entity;

import java.util.Objects;

public class Group {

    private int id;
    private String name;
    private Stream stream;

    public Group(String name, Stream stream) {
        this.name = name;
        this.stream = stream;
    }

    public Group() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Stream getStream() {
        return stream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                name.equals(group.name) &&
                stream.equals(group.stream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stream);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stream=" + stream +
                '}';
    }
}
