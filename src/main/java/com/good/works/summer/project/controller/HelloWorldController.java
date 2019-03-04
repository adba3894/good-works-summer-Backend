package com.good.works.summer.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    private static final String MESSAGE = "Welcome to IT academy project Backend, team 4!";

    @GetMapping(value="")
    public String hello() {
        return MESSAGE;
    }

}
