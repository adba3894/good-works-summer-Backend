package com.good.works.summer.project.repository;

import com.good.works.summer.project.entities.City;
import com.good.works.summer.project.entities.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

    List<Team> findAll();

    boolean existsTeamByLeadName(String leadName);

    boolean existsTeamByLeadEmail(String leadEmail);

    boolean existsTeamByTeamName(String teamName);

    boolean existsTeamByCity(City city);

    boolean existsTeamByOrganization(String organization);

    //List<Team> findTeamsByCityAndOrganization(City city, String organization);

    List<Team> findTeamByOrganization(String organization);

    List<Team> findTeamByCity(City city);


}
