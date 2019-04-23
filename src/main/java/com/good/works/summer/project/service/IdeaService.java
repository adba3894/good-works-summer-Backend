package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.enums.Category;
import com.good.works.summer.project.enums.IdeaState;
import com.good.works.summer.project.exceptions.UniqueIdeaException;
import com.good.works.summer.project.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    public List<Idea> getAllIdeas() {
        return ideaRepository.findAll();
    }

    public Idea addIdea(Idea idea) throws UniqueIdeaException {
        validateIdeaUniqueness(idea);
        Idea newIdea = new Idea();
        newIdea.setState(idea.getState());
        newIdea.setProject(new Project());
        newIdea.setState(IdeaState.PROPOSED);
        newIdea.setDescription(idea.getDescription());
        newIdea.setCity(idea.getCity());
        newIdea.setOrganization(idea.getOrganization());
        newIdea.setCategory(idea.getCategory());
        return ideaRepository.save(newIdea);
    }

    public void validateIdeaUniqueness(Idea ideaToValidate) throws UniqueIdeaException {
        List<Idea> ideas = ideaRepository.findAll();
        for (Idea idea : ideas) {
            if (idea.getDescription().equals(ideaToValidate.getDescription())) {
                throw new UniqueIdeaException();
            }
        }
    }

    public List<Idea> filterIdeasByCategory(Category categoryTitle) {
        List<Idea> filteredIdeasList = ideaRepository.findAll();
        filteredIdeasList = filteredIdeasList.stream()
                .filter(idea -> idea.getCategory().equals(categoryTitle))
                .collect(Collectors.toList());
        return filteredIdeasList;
    }

    public List<Idea> filterIdeasByCategoryWithNoProject(Category categoryTitle) {
        List<Idea> ideas = filterIdeasByCategory(categoryTitle).stream()
                .filter(idea -> idea.getState().equals(IdeaState.PROPOSED))
                .collect(Collectors.toList());
        return ideas;
    }

    public List<Idea> filterIdeasWithNoProject() {
        List<Idea> ideas = ideaRepository.findAll().stream()
                .filter(idea -> idea.getState().equals(IdeaState.PROPOSED))
                .collect(Collectors.toList());
        return ideas;
    }

    public List<Idea> filterIdeasWithDoneProject() {
        List<Idea> ideas = getAllIdeas();
        List<Idea> filteredList = new ArrayList<>();
        for (Idea idea : ideas) {
            if (idea.getProject() != null && idea.getProject().isDone()) {
                filteredList.add(idea);
            }
        }
        return filteredList;
    }

    public void updateIdea(Idea ideaToUpdate) {
        Idea idea = ideaRepository.findIdeaById(ideaToUpdate.getId());
        idea.setState(ideaToUpdate.getState());
        idea.setProject(ideaToUpdate.getProject());
        idea.setDescription(ideaToUpdate.getDescription());
        idea.setCity(ideaToUpdate.getCity());
        idea.setOrganization(ideaToUpdate.getOrganization());
        idea.setCategory(ideaToUpdate.getCategory());
        ideaRepository.save(ideaToUpdate);
    }


}
