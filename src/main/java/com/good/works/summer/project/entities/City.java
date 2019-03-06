package com.good.works.summer.project.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "city_id")
    private int id;

    private String name;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "city_id", nullable = false, referencedColumnName = "team_id")
    @OneToMany(mappedBy="city")
    private List<Team> teams;

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
