package com.good.works.summer.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAdminController {

    @GetMapping
    public String helloAdmin(){
        return "HEY ADMIN!";
    }


}
