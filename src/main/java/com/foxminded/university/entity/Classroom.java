package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    private int number;
    @ManyToOne
    @JoinColumn(name = "floorId")
    private Floor floor;

    public Classroom(int number, Floor floor) {
        this.number = number;
        this.floor = floor;
    }

    public Classroom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFloor(Floor floorId) {
        this.floor = floorId;
    }

    public Floor getFloor() {
        return floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id == classroom.id &&
                number == classroom.number &&
                floor.equals(classroom.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, floor);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", number=" + number +
                ", floor=" + floor +
                '}';
    }

}
