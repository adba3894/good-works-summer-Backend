package com.good.works.summer.project.controller;

import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.exceptions.ProjectNotApprovedException;
import com.good.works.summer.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;


    @GetMapping(value = "/projects")
    public List<Project> listAllProjects() {
        return projectService.getAllProjects();
    }


    @PutMapping(value = "/projects/approve/{projectId}")
    public void approveProject(@PathVariable int projectId) {
        projectService.approveById(projectId);
    }


    @PutMapping(value = "/projects/done/{id}")
    public void makeProjectDone(@PathVariable int id) throws ProjectNotApprovedException {
        projectService.markDoneByID(id);
    }

}
