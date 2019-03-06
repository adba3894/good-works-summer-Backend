package com.good.works.summer.project.entities;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @Column(name = "team_id")
    private int id;

    private String lead_name;

    @Email
    private String lead_email;

    private String team_name;

//    @OneToOne(fetch = FetchType.LAZY,
////            cascade =  CascadeType.ALL,
////            mappedBy = "team")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(mappedBy="team")
    private List<Project> projects;

    private String description;

    public Team(){

    }


    public Team(int id, String lead_name, @Email String lead_email, String team_name, City city, List<Project> projects, String description) {
        this.id = id;
        this.lead_name = lead_name;
        this.lead_email = lead_email;
        this.team_name = team_name;
        this.city = city;
        this.projects = projects;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProject(List<Project> projects) {
        this.projects = projects;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
