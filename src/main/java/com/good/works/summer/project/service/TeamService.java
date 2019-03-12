package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.entities.Team;
import com.good.works.summer.project.enums.Category;
import com.good.works.summer.project.exceptions.UniqueTeamException;
import com.good.works.summer.project.repository.IdeaRepository;
import com.good.works.summer.project.repository.ProjectRepository;
import com.good.works.summer.project.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
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
    public void validateTeamUniqueness(Team teamToCheck) throws UniqueTeamException {
        List<Team> teams = teamRepository.findAll();
        for(Team team: teams) {
            if(checkTeamNameEquality(team, teamToCheck)
                    && checkTeamLeadNameEquality(team, teamToCheck)
                    && checkLeadEmailEquality(team,teamToCheck)
                    && checkCityEquality(team,teamToCheck)
                    && checkOrganizationEquality(team,teamToCheck)
                    && checkIdeaAndCategoryEquality(team, teamToCheck)) {
                throw new UniqueTeamException();
            }
        }
    }

    public boolean checkTeamNameEquality(Team team, Team teamToCheck){
        return team.getTeamName().equals(teamToCheck.getTeamName());
    }

    public boolean checkTeamLeadNameEquality(Team team, Team teamToCheck){
        return team.getLeadName().equals(teamToCheck.getLeadName());
    }

    public boolean checkLeadEmailEquality(Team team, Team teamToCheck){
        return team.getLeadEmail().equals(teamToCheck.getLeadEmail());
    }

    public boolean checkCityEquality(Team team, Team teamToCheck) {
        return team.getCity().getId()==(teamToCheck.getCity().getId());
    }

    public boolean checkOrganizationEquality(Team team, Team teamToCheck){
        return team.getOrganization().equals(teamToCheck.getOrganization());
    }

    public boolean checkIdeaAndCategoryEquality(Team team, Team teamToCheck){
        return ifTeamWithSameIdeaAndCategoryExists(team, teamToCheck);
    }

    public boolean ifTeamWithSameIdeaAndCategoryExists(Team team, Team teamToCheck){
        for(Idea idea: team.getIdeas()){
            for(Idea ideaToCheck: teamToCheck.getIdeas()){
                if(checkIdeasEquality(idea,ideaToCheck) && checkCategoriesEquality(idea, ideaToCheck)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIdeasEquality(Idea idea, Idea ideaToCheck){
        return idea.getDescription().equals(ideaToCheck.getDescription());
    }

    public boolean checkCategoriesEquality(Idea idea, Idea ideaToCheck){
        return idea.getProject().getCategory().equals(ideaToCheck.getProject().getCategory());
    }

}
