package com.foxminded.university.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return number == floor.number &&
                building.equals(floor.building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, building);
    }

    @Override
    public String toString() {
        return "Floor{" +
                "number=" + number +
                ", building=" + building +
                '}';
    }
}
