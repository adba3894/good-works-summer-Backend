package com.good.works.summer.project.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.good.works.summer.project.enums.Category;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "idea")
public class Idea {

    @Id
    @Column(name = "idea_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(max=240)
    @NotNull
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Team team;

    @NotNull
    @Size(max=100)
    private String organization;

    @NotNull
    private Category category;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Idea() {
    }

    public Idea(@NotNull String description, Project project, Team team, @NotNull String organization, @NotNull Category category, City city) {
        this.description = description;
        this.project = project;
        this.team = team;
        this.organization = organization;
        this.category = category;
        this.city = city;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
