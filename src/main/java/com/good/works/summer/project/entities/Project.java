package com.good.works.summer.project.entities;

import com.good.works.summer.project.enums.Category;

import javax.persistence.*;

//@Entity
//@Table(name = "project")
public class Project {

    @Id

    private int project_id;


    //
    private Category category;

    //
    private Idea idea;


    public Project(int project_id, Category category, Idea idea) {
        this.project_id = project_id;
        this.category = category;
        this.idea = idea;
    }


    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
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
}
