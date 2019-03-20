package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Project;
import com.good.works.summer.project.exceptions.ProjectNotApprovedException;
import com.good.works.summer.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.good.works.summer.project.enums.IdeaState.PROPOSED;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void approveById(int projectId) {
        Project project = projectRepository.findById(projectId);
        project.getIdea().setState(PROPOSED);
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
        int totalProjects = projectRepository.findAll().size();
        if(totalProjects == 0){
            return 0;
        }
        return (projectsDone * 100 / totalProjects);
    }
}
