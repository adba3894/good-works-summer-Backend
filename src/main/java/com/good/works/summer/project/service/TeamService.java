package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.entities.Team;
import com.good.works.summer.project.exceptions.UniqueTeamException;
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

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public List<Idea> getAllIdeas() {
        return ideaRepository.findAll();
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    //Main validation method
    public void validateTeamUniqueness(Team team) throws UniqueTeamException {
        if(existByTeamName(team)
                && existsByTeamLeadName(team)
                && existByTeamLeadEmail(team)
                && existByTeamCity(team)
                && existsByTeamOrganization(team)
                && existByTeamIdeas()) {
            throw new UniqueTeamException();
        }
    }

    public boolean existByTeamName(Team team) {
        return teamRepository.existsTeamByTeamName(team.getTeamName());
    }

    public boolean existsByTeamLeadName(Team team) {
        return teamRepository.existsTeamByLeadName(team.getLeadName());
    }

    public boolean existByTeamLeadEmail(Team team) {
        return teamRepository.existsTeamByLeadEmail(team.getLeadEmail());
    }

    public boolean existByTeamCity(Team team) {
        return teamRepository.existsTeamByCity(team.getCity());
    }

    public boolean existsByTeamOrganization(Team team) {
        return teamRepository.existsTeamByOrganization(team.getOrganization());
    }

    public boolean existByTeamIdeas() {
        return ifTeamWithSameIdeaAndCategoryExists();
    }


    public boolean ifTeamWithSameIdeaAndCategoryExists(){
        List<Team> teams = teamRepository.findAll();
        for(Team teamObj: teams) {
            List<Idea> ideas = teamObj.getIdeas();
            for (Idea ideaObj: ideas) {
                if (ifTeamWithSameDescriptionExist(ideaObj) && ifTeamWithSameCategoryExist(ideaObj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ifTeamWithSameDescriptionExist(Idea ideaObj){
        return ideaObj.getDescription().equals(ideaObj.getDescription());
    }

    public boolean ifTeamWithSameCategoryExist(Idea ideaObj){
        return ideaObj.getProject().getCategory().equals(ideaObj.getProject().getCategory());
    }
}
