package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.City;
import com.good.works.summer.project.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    public CityRepository cityRepository;


    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public Iterable<City> save(List<City> cities) {
        return cityRepository.saveAll(cities);
    }



}
