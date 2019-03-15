package com.good.works.summer.project.controller;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.entities.Team;
import com.good.works.summer.project.enums.Category;
import com.good.works.summer.project.exceptions.TeamSizeException;
import com.good.works.summer.project.exceptions.UniqueTeamException;
import com.good.works.summer.project.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping(value = "/register")
    public Team registerTeam(@RequestBody Team team) throws UniqueTeamException, TeamSizeException {
        teamService.validateTeamUniqueness(team);
        //teamService.ifOrganizationHasMoreThanFiveTeamsInSameCity(team);
        return teamService.createTeam(team);
    }

    @GetMapping(value = "/teams/filter/{categoryName}")
    public List<Team> filtered(@PathVariable String categoryName){
        return teamService.filterTeamsByCategory(Category.valueOf(categoryName));
    }

    @GetMapping(value="/teams")
    public List<Team> listAllTeams(){
        return teamService.getAllTeams();
    }



}
