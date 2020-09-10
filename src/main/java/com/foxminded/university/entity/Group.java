package com.foxminded.university.entity;

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
}
