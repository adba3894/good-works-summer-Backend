package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    public List<Idea> getAllIdeas() {
        return ideaRepository.findAll();
    }

    public Idea addIdea(Idea idea) {
        return ideaRepository.save(idea);
    }

}
