package com.good.works.summer.project.controller;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IdeaController {

    @Autowired
    private IdeaService ideaService;

    @GetMapping(value="/ideas")
    public List<Idea> listAllIdeas(){
        return ideaService.getAllIdeas();
    }

    @PostMapping(value = "/ideas/add")
    public void addNewIdea(@RequestBody Idea idea){
        ideaService.addIdea(idea);
    }
}
