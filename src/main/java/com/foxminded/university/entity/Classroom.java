package com.foxminded.university.entity;

import java.util.Objects;

public class Classroom {

    private int number;
    private Floor floor;

    public Classroom(int number, Floor floor) {
        this.number = number;
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return number == classroom.number &&
                Objects.equals(floor, classroom.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, floor);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "number=" + number +
                ", floor=" + floor +
                '}';
    }
}
