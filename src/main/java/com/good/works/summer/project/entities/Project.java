package com.good.works.summer.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.good.works.summer.project.enums.Category;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private Category category;

    @OneToOne
    @JoinColumn(name = "idea_id", referencedColumnName = "idea_id")
    @JsonIgnore
    private Idea idea;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Team team;

    @NotNull
    private boolean isApproved;

    public Project(Category category, Idea idea, Team team) {
        this.category = category;
        this.idea = idea;
        this.team = team;
        this.isApproved = false;
    }

    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved() {
        isApproved = true;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
