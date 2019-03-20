package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.entities.Team;
import com.good.works.summer.project.enums.Category;
import com.good.works.summer.project.enums.IdeaState;
import com.good.works.summer.project.exceptions.TeamSizeException;
import com.good.works.summer.project.exceptions.UniqueTeamException;
import com.good.works.summer.project.repository.IdeaRepository;
import com.good.works.summer.project.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.good.works.summer.project.enums.IdeaState.PROPOSED;


@Service
public class TeamService {

    @Autowired
    public TeamRepository teamRepository;

    @Autowired
    public IdeaRepository ideaRepository;

    public Team createTeam(Team team) throws UniqueTeamException, TeamSizeException {
        List<Idea> ideas = extractIdeaFromTeam(team);

        Team teamToCreate = new Team();
        teamToCreate.setLeadName(team.getLeadName());
        teamToCreate.setTeamName(team.getTeamName());
        teamToCreate.setLeadEmail(team.getLeadEmail());
        teamToCreate.setIdeas(ideas);

        validateTeamUniqueness(teamToCreate);
        doesOrganizationHasMoreThanFiveTeamsInSameCity(teamToCreate);
        return teamRepository.save(teamToCreate);
    }

    public List<Team> getAllTeams() {
        return sortByDescOrder(teamRepository.findAll());
    }

    public List<Team> sortByDescOrder(List<Team> teams) {
        return teams.stream()
                .sorted((a, b) -> b.getId() - a.getId())
                .collect(Collectors.toList());
    }

    public void updateTeamInfo(Team team) {
        team.setLeadName(team.getLeadName());
        team.setLeadEmail(team.getLeadEmail());
        team.setTeamName(team.getTeamName());
        team.setIdeas(team.getIdeas());
        teamRepository.save(team);
    }

    public void validateTeamUniqueness(Team teamToCheck) throws UniqueTeamException {
        List<Team> teams = teamRepository.findAll();
        for (Team team : teams) {
            if (checkTeamNameEquality(team, teamToCheck)
                    && checkTeamLeadNameEquality(team, teamToCheck)
                    && checkLeadEmailEquality(team, teamToCheck)
                    && checkCityEquality(team, teamToCheck)
                    && checkOrganizationEquality(team, teamToCheck)
                    && checkIdeaAndCategoryEquality(team, teamToCheck)) {
                throw new UniqueTeamException();
            }
        }
    }

    public boolean checkTeamNameEquality(Team team, Team teamToCheck) {
        return team.getTeamName().equals(teamToCheck.getTeamName());
    }

    public boolean checkTeamLeadNameEquality(Team team, Team teamToCheck) {
        return team.getLeadName().equals(teamToCheck.getLeadName());
    }

    public boolean checkLeadEmailEquality(Team team, Team teamToCheck) {
        return team.getLeadEmail().equals(teamToCheck.getLeadEmail());
    }

    public boolean checkCityEquality(Team team, Team teamToCheck) {
        for (Idea idea : team.getIdeas()) {
            for (Idea ideaToCheck : teamToCheck.getIdeas()) {
                if (idea.getCity().getId() == ideaToCheck.getCity().getId()) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkOrganizationEquality(Team team, Team teamToCheck) {
        for (Idea idea : team.getIdeas()) {
            for (Idea ideaToCheck : teamToCheck.getIdeas()) {
                if (idea.getOrganization().equals(ideaToCheck.getOrganization())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIdeaAndCategoryEquality(Team team, Team teamToCheck) {
        return doesTeamWithSameIdeaAndCategoryExists(team, teamToCheck);

    }

    public boolean doesTeamWithSameIdeaAndCategoryExists(Team team, Team teamToCheck) {
        for (Idea idea : team.getIdeas()) {
            for (Idea ideaToCheck : teamToCheck.getIdeas()) {
                if (checkIdeasEquality(idea, ideaToCheck) && checkCategoriesEquality(idea, ideaToCheck)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIdeasEquality(Idea idea, Idea ideaToCheck) {
        return idea.getDescription().equals(ideaToCheck.getDescription());
    }

    public boolean checkCategoriesEquality(Idea idea, Idea ideaToCheck) {
        return idea.getCategory().equals(ideaToCheck.getCategory());
    }

    public void doesOrganizationHasMoreThanFiveTeamsInSameCity(Team teamToCheck) throws TeamSizeException {
        int resultChecker = 0;
        for (Team iteratingTeam : getAllTeams()) {
            for (Idea iteratingIdea : iteratingTeam.getIdeas()) {
                for (Idea ideaToCheck : teamToCheck.getIdeas()) {
                    if (iteratingIdea.getOrganization().equals(ideaToCheck.getOrganization())
                            && iteratingIdea.getCity().getId() == ideaToCheck.getCity().getId()) {
                        resultChecker++;
                    }
                }
            }
        }
        if (resultChecker >= 5) {
            throw new TeamSizeException();
        }
    }

    //cia keista biski
    public List<Team> filterTeamsByCategory(Category categoryTitle) {
        List<Team> filteredTeamsList = teamRepository.findAll();
        filteredTeamsList = filteredTeamsList.stream()
                .filter(team -> team.getIdeas().stream()
                        .anyMatch(idea -> idea.getCategory().equals(categoryTitle)
                                && idea.getProject().getIdea().getState() == PROPOSED
                                && idea.getProject().isApproved()))
                .sorted((a, b) -> b.getId() - a.getId())
                .collect(Collectors.toList());
        return filteredTeamsList;
    }

    public List<Idea> extractIdeaFromTeam(Team team) {
        List<Idea> ideas = new ArrayList<>();
        for (Idea idea : team.getIdeas()) {
            if (idea.getId() != 0) {
                Idea existingIdea = ideaRepository.findById(idea.getId()).get();
                existingIdea.setState(IdeaState.TAKEN);
                ideas.add(existingIdea);
            }
            else {
                Idea newIdea = new Idea();
                newIdea.setState(idea.getState());
                newIdea.setProject(idea.getProject());
                newIdea.setCity(idea.getCity());
                newIdea.setDescription(idea.getDescription());
                newIdea.setOrganization(idea.getOrganization());
                newIdea.setCategory(idea.getCategory());
                newIdea.setState(IdeaState.WAITING_FOR_REVIEW);
                ideas.add(newIdea);
            }
        }
        return ideas;
    }

}
