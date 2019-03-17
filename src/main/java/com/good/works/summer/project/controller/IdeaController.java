package com.good.works.summer.project.controller;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.exceptions.UniqueIdeaException;
import com.good.works.summer.project.service.IdeaService;
import com.good.works.summer.project.enums.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class IdeaController {

    @Autowired
    private IdeaService ideaService;

    @GetMapping(value = "/ideas")
    public List<Idea> listAllIdeas() {
        return ideaService.getAllIdeas();
    }

    @PostMapping(value = "/ideas/add")
    public void addNewIdea(@RequestBody Idea idea) throws UniqueIdeaException {
        ideaService.validateIdeaUniqueness(idea);
        ideaService.addIdea(idea);
    }

    @GetMapping(value = "/ideas/filter/{category}")
    public List<Idea> filterIdeasByCategory(@PathVariable String category) {
        return ideaService.filterIdeasByCategory(Category.valueOf(category));
    }

    @GetMapping(value = "/ideas/filter/{category}/free")
    public List<Idea> filterIdeasWithNoProject(@PathVariable String category){
        return ideaService.filterIdeasByCategoryWithNoProject(Category.valueOf(category));
    }

//    @GetMapping(value = "/ideas/free")
//    public List<Idea> filterIdeasWithNoProject(){
//        return ideaService.filterIdeasWithNoProject();
//    }

}
