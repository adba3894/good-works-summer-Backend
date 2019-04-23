package com.good.works.summer.project.service;

import com.good.works.summer.project.enums.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    public List<String> getAllCategories() {
        return Category.categories();
    }

}
