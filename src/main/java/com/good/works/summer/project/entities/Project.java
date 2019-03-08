package com.good.works.summer.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.good.works.summer.project.enums.Category;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Entity
@Table(name = "project")
public class  Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idea_id", referencedColumnName = "idea_id")
    @JsonIgnore
    private Idea idea;

    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "team_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Team team;

    public Project(Category category, Idea idea, Team team) {
        this.category = category;
        this.idea = idea;
        this.team = team;
    }

    public Project(){}

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }



}
