package com.good.works.summer.project.controller;

import com.good.works.summer.project.model.City;
import com.good.works.summer.project.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping(value="lithuaniaCities")
    public List<City> getAllCities(){
        if(cityService.getSizeOfCitiesDatabase() == 0) {
            cityService.createCities();
        }
        return cityService.getAllCities();

    }


}
