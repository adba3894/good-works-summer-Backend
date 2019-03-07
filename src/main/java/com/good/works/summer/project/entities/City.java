package com.good.works.summer.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "city_id")
    private int id;

    private String name;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public City(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setCity_name(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
