package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.exceptions.ProjectNotApprovedException;
import com.good.works.summer.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void approveById(int projectId) {
        Project project = projectRepository.getProjectById(projectId);
        project.setApproved(true);
        projectRepository.save(project);
    }

    public void markDoneByID(int projectId) throws ProjectNotApprovedException {
        Project project = projectRepository.getProjectById(projectId);
        if (project.isApproved()) {
            project.setDone(true);
        } else {
            throw new ProjectNotApprovedException();
        }
        projectRepository.save(project);
    }

}