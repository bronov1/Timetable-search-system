package com.foxminded.university.entity;

import java.util.Objects;

public class Group {

    private int id;
    private String name;
    private int streamId;

    public Group(String name, int streamId) {
        this.name = name;
        this.streamId = streamId;
    }

    public Group() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStringId() {
        return String.valueOf(id);
    }

    public int getStreamId() {
        return streamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreamId(int streamId) {
        this.streamId = streamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                streamId == group.streamId &&
                name.equals(group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, streamId);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", streamId=" + streamId +
                '}';
    }

}
