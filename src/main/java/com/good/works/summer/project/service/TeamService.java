package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Team;
import com.good.works.summer.project.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    public TeamRepository teamRepository;

    public Team createTeam(Team team){
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

}
