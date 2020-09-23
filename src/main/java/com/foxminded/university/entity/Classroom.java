package com.foxminded.university.entity;

import java.util.Objects;

public class Classroom {

    private int id;
    private int number;
    private int floorId;

    public Classroom(int number, int floorId) {
        this.number = number;
        this.floorId = floorId;
    }

    public Classroom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getFloorId() {
        return floorId;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", number=" + number +
                ", floorId=" + floorId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id == classroom.id &&
                number == classroom.number &&
                floorId == classroom.floorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, floorId);
    }

}
