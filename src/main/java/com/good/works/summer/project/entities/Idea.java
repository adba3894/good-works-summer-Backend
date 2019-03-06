package com.good.works.summer.project.entities;


import javax.persistence.*;

@Entity
@Table(name="idea")
public class Idea {

    @Id
    @Column(name = "idea_id")
    private int id;

    private String description;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idea_id", nullable = false, referencedColumnName = "idea_id")
    private Project project;


    public Idea(){

    }

    public Idea(int id, String description) {
        this.id = id;
        this.description = description;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
