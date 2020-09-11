package com.foxminded.university.entity;

import java.util.Arrays;
import java.util.Objects;

public class Department {

    private String name;
    private Professor[] professors;

    public Department(String name, Professor[] professors) {
        this.name = name;
        this.professors = professors;
    }

    public String getName() {
        return name;
    }

    public Professor[] getProfessors() {
        return professors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessors(Professor[] professors) {
        this.professors = professors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return name.equals(that.name) &&
                Arrays.equals(professors, that.professors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(professors);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", professors=" + Arrays.toString(professors) +
                '}';
    }
}
