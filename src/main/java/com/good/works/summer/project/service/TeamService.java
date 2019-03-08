package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.entities.Team;
import com.good.works.summer.project.repository.IdeaRepository;
import com.good.works.summer.project.repository.ProjectRepository;
import com.good.works.summer.project.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    public TeamRepository teamRepository;

    @Autowired
    private IdeaRepository ideaRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Team createTeam(Team team){
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public List<Idea> getAllIdeas(){
        return ideaRepository.findAll();
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteAllTeams(){
        teamRepository.deleteAll();
    }

    public void deleteAllIdeas(){
        ideaRepository.deleteAll();
    }

    public void deleteAllProjects(){
        projectRepository.deleteAll();
    }

//pasitiklsinti del strukturos
}
