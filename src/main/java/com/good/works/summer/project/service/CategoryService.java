package com.good.works.summer.project.service;

import com.good.works.summer.project.model.Category;
import com.good.works.summer.project.model.City;
import com.good.works.summer.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    //beautiful envirnonment, giving back to society, helping Animals, sharing knowledge
    public void createCategories(){
        categoryRepository.saveAll(Arrays.asList(
                new Category(1,"Beautiful Envirnonment"),
                new Category(2,"Giving Back To Society"),
                new Category(3,"Helping Animals"),
                new Category(4,"Sharing Knowledge")
        ));
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Iterable<Category> save(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }



}
