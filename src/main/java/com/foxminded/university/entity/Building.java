package com.foxminded.university.entity;

import java.util.Objects;

public class Building {

    private String name;
    private int floors;

    public Building(String name, int floors) {
        this.name = name;
        this.floors = floors;
    }

    public String getName() {
        return name;
    }

    public int getFloors() {
        return floors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return floors == building.floors &&
                name.equals(building.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, floors);
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", floors=" + floors +
                '}';
    }
}
