package com.foxminded.university.entity;

public class Department {

    private String name;
    private Professor[] professors;
    private University university;

    public Department(String name, Professor[] professors, University university) {
        this.name = name;
        this.professors = professors;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public Professor[] getProfessors() {
        return professors;
    }

    public University getUniversity() {
        return university;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessors(Professor[] professors) {
        this.professors = professors;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
