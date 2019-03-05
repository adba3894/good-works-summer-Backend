package com.good.works.summer.project;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.good.works.summer.project.model.Category;
import com.good.works.summer.project.model.City;
import com.good.works.summer.project.service.CategoryService;
import com.good.works.summer.project.service.CityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner citiesRunner(CityService cityService) {
		return args -> {
			// read json and write cities to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<City>> typeReference = new TypeReference<List<City>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/cities.json");
			try {
				List<City> cities = mapper.readValue(inputStream,typeReference);
				cityService.save(cities);
				System.out.println("Cities Saved!");
			} catch (IOException e){
				System.out.println("Unable to save cities: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner categoriesRunner(CategoryService categoryService) {
		return args -> {
			// read json and write categories to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Category>> typeReference = new TypeReference<List<Category>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/categories.json");
			try {
				List<Category> categories = mapper.readValue(inputStream,typeReference);
				categoryService.save(categories);
				System.out.println("Categories Saved!");
			} catch (IOException e){
				System.out.println("Unable to save categories: " + e.getMessage());
			}
		};
	}


}



