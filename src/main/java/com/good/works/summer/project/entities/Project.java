package com.good.works.summer.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "project")
public class  Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "idea_id", referencedColumnName = "idea_id")
    @JsonIgnore
    private Idea idea;

    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "team_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Team team;

    @NotNull
    @Column(columnDefinition = "boolean default false")
    private boolean isApproved;

    @NotNull
    @Column(columnDefinition = "boolean default false")
    private boolean isDone;

    public Project(Idea idea, Team team, @NotNull boolean isApproved, @NotNull boolean isDone) {
        this.idea = idea;
        this.team = team;
        this.isApproved = isApproved;
        this.isDone = isDone;
    }

    public Project(){}

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
