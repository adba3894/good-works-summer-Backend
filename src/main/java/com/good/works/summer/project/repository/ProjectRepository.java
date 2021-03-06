package com.good.works.summer.project.repository;

import com.good.works.summer.project.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

    List<Project> findAll();

    List<Project> findAllByIsDone(boolean isDone);

    Project findById(int id);

    List<Project> findAllByIsApproved(boolean isApproved);

}
