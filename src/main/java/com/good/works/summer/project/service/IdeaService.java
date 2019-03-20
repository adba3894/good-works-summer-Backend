package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Idea;
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

    public Idea addIdea(Idea idea) throws UniqueIdeaException{
        validateIdeaUniqueness(idea);
        Idea newIdea = new Idea();
        newIdea.setState(idea.getState());
        newIdea.setProject(idea.getProject());
        newIdea.setState(IdeaState.PROPOSED);
        newIdea.setDescription(idea.getDescription());
        newIdea.setCity(idea.getCity());
        newIdea.setOrganization(idea.getOrganization());
        newIdea.setCategory(idea.getCategory());
        //idea.setProject(null); //****
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
        return ideasFilter(ideas);
    }

    public List<Idea> filterIdeasWithNoProject() {
        List<Idea> ideas = ideaRepository.findAll();
        return ideasFilter(ideas);
    }

    public List<Idea> ideasFilter(List<Idea> ideas) {
        List<Idea> filteredIdeas = new ArrayList<>();
        for (Idea idea : ideas) {
            if (idea.getProject() == null) {
                filteredIdeas.add(idea);
            }
        }
        return filteredIdeas;
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

}
