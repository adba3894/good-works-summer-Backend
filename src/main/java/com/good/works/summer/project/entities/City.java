package com.good.works.summer.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

    @Id
    private int id;

    private String name;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public City(){

    }

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
}
