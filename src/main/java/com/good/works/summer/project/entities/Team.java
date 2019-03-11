package com.good.works.summer.project.entities;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
//@Table(name = "team", uniqueConstraints = {
//        @UniqueConstraint(name = "uniqueTeamConstraint", columnNames = {"leadName","teamName", "leadEmail", "city_id", "organization", "team_id"})})
@Table(name="team")
public class Team {

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String leadName;

    @NotNull
    @NotEmpty
    @Email(message = "email must contain '@' symbol")
    private String leadEmail;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private List<Idea> ideas;

    @NotNull
    @NotEmpty
    private String organization;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Team(String leadName, @Email String leadEmail, String teamName, City city, List<Idea> ideas, String organization) {
        this.leadName = leadName;
        this.leadEmail = leadEmail;
        this.teamName = teamName;
        this.city = city;
        this.ideas = ideas;
        this.organization = organization;
    }

    public Team(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getLeadEmail() {
        return leadEmail;
    }

    public void setLeadEmail(String leadEmail) {
        this.leadEmail = leadEmail;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(List<Idea> ideas) {
        this.ideas = ideas;
    }



}