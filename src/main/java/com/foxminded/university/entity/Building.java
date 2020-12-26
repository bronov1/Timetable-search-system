package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "floors")
    private int floors;

    public Building(String name, int floors) {
        this.name = name;
        this.floors = floors;
    }

    public Building() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
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
        return id == building.id &&
                floors == building.floors &&
                name.equals(building.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, floors);
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floors=" + floors +
                '}';
    }
}
