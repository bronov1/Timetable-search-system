package com.foxminded.university.entity;

public class Building {

    private String name;
    private int floors;
    private University university;

    public Building(String name, int floors, University university) {
        this.name = name;
        this.floors = floors;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public int getFloors() {
        return floors;
    }

    public University getUniversity() {
        return university;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
