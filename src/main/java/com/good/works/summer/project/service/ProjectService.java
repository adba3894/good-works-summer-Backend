package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Idea;
import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.exceptions.ProjectNotApprovedException;
import com.good.works.summer.project.repository.IdeaRepository;
import com.good.works.summer.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.good.works.summer.project.enums.IdeaState.TAKEN;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private IdeaRepository ideaRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void approveById(int projectId) {
        Project project = projectRepository.findById(projectId);
        Idea idea = ideaRepository.findByProject(project);
        idea.setState(TAKEN);
        ideaRepository.save(idea);
        project.setApproved(true);
        projectRepository.save(project);
    }

    public void markDoneByID(int projectId) throws ProjectNotApprovedException {
        Project project = projectRepository.findById(projectId);
        if (project.isApproved()) {
            project.setDone(true);
        } else {
            throw new ProjectNotApprovedException();
        }
        projectRepository.save(project);
    }

    public int calculatePercentage() {
        int projectsDone = projectRepository.findAllByIsDone(true).size();
        int totalProjects = projectRepository.findAllByApproved(true).size();
        if (totalProjects == 0) {
            return 0;
        }
        return (projectsDone * 100 / totalProjects);
    }
}
