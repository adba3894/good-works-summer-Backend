package com.good.works.summer.project.service;

import com.good.works.summer.project.model.City;
import com.good.works.summer.project.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CityService {

    @Autowired
    public CityRepository cityRepository;


    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public void createCities(){
        cityRepository.saveAll(Arrays.asList(
                new City(2, "Vilnius"),
                new City(3, "Kaunas"),
                new City(4, "Klaipėda"),
                new City(5, "Šiauliai"),
                new City(6, "Panevėžys"),
                new City(7, "Akmenė"),
                new City(8, "Alytus"),
                new City(9, "Anykščiai"),
                new City(10, "Birštonas"),
                new City(11, "Biržai"),
                new City(12, "Druskininkai"),
                new City(13, "Elektrėnai"),
                new City(14, "Ignalina"),
                new City(15, "Jonava"),
                new City(16, "Joniškis"),
                new City(17, "Jurbarkas"),
                new City(18, "Kaišiadorys"),
                new City(19, "Kalvarija"),
                new City(20, "Kėdainiai"),
                new City(21, "Kelmė"),
                new City(22, "Kretinga"),
                new City(22, "Kupiškis"),
                new City(23, "Lazdijai"),
                new City(24, "Marijampolė"),
                new City(25, "Mažeikiai"),
                new City(26, "Molėtai"),
                new City(27, "Neringa"),
                new City(28, "Pagėgiai"),
                new City(29, "Pakruojis"),
                new City(30, "Palanga"),
                new City(31, "Pasvalys"),
                new City(32, "Plungė"),
                new City(33, "Prienai"),
                new City(34, "Radviliškis"),
                new City(35, "Raseiniai"),
                new City(36, "Rietavas"),
                new City(37, "Rokiškis"),
                new City(38, "Šakiai"),
                new City(39, "Šalčininkai"),
                new City(40, "Šilalė"),
                new City(41, "Širvintos"),
                new City(42, "Skuodas"),
                new City(43, "Švenčionys"),
                new City(44, "Tauragė"),
                new City(45, "Telšiai"),
                new City(46, "Trakai"),
                new City(47, "Ukmergė"),
                new City(48, "Utena"),
                new City(49, "Varėna"),
                new City(50, "Vilkaviškis"),
                new City(51, "Visaginas"),
                new City(52, "Zarasai")
                ));
    }

    public int getSizeOfCitiesDatabase(){
        return Math.toIntExact(cityRepository.count());
    }


}
