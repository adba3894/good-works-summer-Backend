package com.good.works.summer.project.controller;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.entities.Team;
import com.good.works.summer.project.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    public TeamService teamService;

    @PostMapping(value = "/registration")
    public Team registerTeam(@RequestBody Team team){
        team.setIdeas(team.getIdeas());
        return teamService.createTeam(team);
    }

    @GetMapping(value="/teams")
    public List<Team> listAllTeams(){
        //teamService.deleteAllTeams();
        return teamService.getAllTeams();
    }

    @GetMapping(value="/ideas")
    public List<Idea> listAllIdeas(){
        //teamService.deleteAllIdeas();
        return teamService.getAllIdeas();
    }

    @GetMapping(value="/projects")
    public List<Project> listAllProjects(){
        //teamService.deleteAllProjects();
        return teamService.getAllProjects();
    }
}
