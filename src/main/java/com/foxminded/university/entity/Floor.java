package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "floors")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    private int number;
    @ManyToOne
    @JoinColumn(name = "buildingid")
    private Building building;

    public Floor(int number, Building building) {
        this.number = number;
        this.building = building;
    }

    public Floor() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBuilding(Building buildingId) {
        this.building = buildingId;
    }

    public Building getBuilding() {
        return building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return id == floor.id &&
                number == floor.number &&
                building.equals(floor.building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, building);
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", number=" + number +
                ", building=" + building +
                '}';
    }

}
