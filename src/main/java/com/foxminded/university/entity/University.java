package com.foxminded.university.entity;

public class University {

    private String name;
    private Building[] buildings;
    private Department[] departments;
    private Student[] students;
    private Professor[] professors;

    public University(String name, Building[] buildings, Department[] departments, Student[] students, Professor[] professors) {
        this.name = name;
        this.buildings = buildings;
        this.departments = departments;
        this.students = students;
        this.professors = professors;
    }

    public String getName() {
        return name;
    }

    public Building[] getBuildings() {
        return buildings;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public Student[] getStudents() {
        return students;
    }

    public Professor[] getProfessors() {
        return professors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuildings(Building[] buildings) {
        this.buildings = buildings;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setProfessors(Professor[] professors) {
        this.professors = professors;
    }
}
