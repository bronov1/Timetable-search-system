package com.foxminded.university.entity;

public class Floor {

    private int number;
    private Building building;

    public Floor(int number, Building building) {
        this.number = number;
        this.building = building;
    }

    public int getNumber() {
        return number;
    }

    public Building getBuilding() {
        return building;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
