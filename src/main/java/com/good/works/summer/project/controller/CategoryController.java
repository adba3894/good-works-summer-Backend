package com.good.works.summer.project.controller;


import com.good.works.summer.project.model.Category;
import com.good.works.summer.project.repository.CategoryRepository;
import com.good.works.summer.project.service.CategoryService;
import com.good.works.summer.project.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/initialdata")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "/categories")
    public List<Category> getAllCategories(){
        categoryService.createCategories();
        return categoryService.getAllCategories();
    }



}
