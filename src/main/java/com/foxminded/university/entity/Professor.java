package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "professors")
public class Professor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    public Professor(String name, Department department) {
        super(name);
        this.department = department;
    }

    public Professor() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "department=" + department +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return id == professor.id &&
                department.equals(professor.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, department);
    }
}
