package com.good.works.summer.project.repository;

import com.good.works.summer.project.entities.Idea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Integer> {

    List<Idea> findAll();

}
