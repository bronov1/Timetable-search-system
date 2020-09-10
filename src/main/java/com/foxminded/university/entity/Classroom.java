package com.foxminded.university.entity;

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
}
