package com.good.works.summer.project.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

//@Entity
//@Table(name = "team")
public class Team {

    @Id
    private int team_id;

    private String lead_name;

    @Email
    private String lead_email;

    private String team_name;

    //
    private City city;

    //
    private Project project;

    private String description;

    public Team(){

    }


    public Team(int team_id, String lead_name, @Email String lead_email, String team_name, City city, Project project, String description) {
        this.team_id = team_id;
        this.lead_name = lead_name;
        this.lead_email = lead_email;
        this.team_name = team_name;
        this.city = city;
        this.project = project;
        this.description = description;
    }


    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getLead_name() {
        return lead_name;
    }

    public void setLead_name(String lead_name) {
        this.lead_name = lead_name;
    }

    public String getLead_email() {
        return lead_email;
    }

    public void setLead_email(String lead_email) {
        this.lead_email = lead_email;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
