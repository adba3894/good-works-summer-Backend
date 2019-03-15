package com.good.works.summer.project.controller;

import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;


    @GetMapping(value="/projects")
    public List<Project> listAllProjects(){
        return projectService.getAllProjects();
    }


}
