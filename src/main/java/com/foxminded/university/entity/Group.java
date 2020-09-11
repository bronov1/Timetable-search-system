package com.foxminded.university.entity;

import java.util.Objects;

public class Group {

    private String name;
    private Stream stream;

    public Group(String name, Stream stream) {
        this.name = name;
        this.stream = stream;
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
        return name.equals(group.name) &&
                stream.equals(group.stream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stream);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", stream=" + stream +
                '}';
    }
}
