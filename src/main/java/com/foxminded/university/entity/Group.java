package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "streamid")
    private Stream stream;
    @ManyToMany()
    @JoinTable(name = "lecturegroups",
            joinColumns = @JoinColumn(name = "groupid"),
            inverseJoinColumns = @JoinColumn(name = "lectureid"))
    private List<Lecture> lectures = new ArrayList<>();

    public Group(String name, Stream stream) {
        this.name = name;
        this.stream = stream;
    }

    public Group() {
    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
        lecture.getGroups().add(this);
    }

    public void removeLecture(Lecture lecture) {
        lectures.remove(lecture);
        lecture.getGroups().remove(this);
    }

    public List<Lecture> getLectures() {
        return lectures;
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

    public Stream getStream() {
        return stream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStream(Stream streamId) {
        this.stream = streamId;
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
