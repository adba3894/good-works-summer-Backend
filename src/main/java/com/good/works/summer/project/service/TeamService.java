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
                && existByTeamIdeas(team)) {
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

    public boolean existByTeamIdeas(Team team) {
        return ifTeamWithSameIdeaAndCategoryExists(team);
    }

    public boolean ifTeamWithSameIdeaAndCategoryExists(Team team){

        List<Team> teams = teamRepository.findAll();

        for(int i = 0; i < teams.size(); i++) {
            List<Idea> ideas = teams.get(i).getIdeas();
            for (int j = 0; j < ideas.size(); j++) {
                if (ifTeamWithSameDescriptionExist(team, ideas, j) && ifTeamWithSameCategoryExist(team,ideas, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ifTeamWithSameDescriptionExist(Team team, List<Idea> ideas, int j){
        return ideas.get(j).getDescription().equals(team.getIdeas().get(j).getDescription());
    }

    public boolean ifTeamWithSameCategoryExist(Team team, List<Idea> ideas, int j){
        return ideas.get(j).getProject().getCategory().equals(team.getIdeas().get(j).getProject().getCategory());
    }
}
