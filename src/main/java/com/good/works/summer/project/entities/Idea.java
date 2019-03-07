package com.good.works.summer.project.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="idea")
public class Idea {

    @Id
    @Column(name = "idea_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idea_id", referencedColumnName = "idea_id")
    private Project project;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "team_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Team team;

    public Idea(){}

    public Idea(String description, Project project, Team team) {
        this.description = description;
        this.project = project;
        this.team = team;
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