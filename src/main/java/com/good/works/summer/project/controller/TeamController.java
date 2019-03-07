package com.good.works.summer.project.controller;

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
        return teamService.getAllTeams();
    }

}
