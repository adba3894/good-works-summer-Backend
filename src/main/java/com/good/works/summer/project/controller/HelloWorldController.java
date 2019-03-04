package com.good.works.summer.project.controller;

import com.good.works.summer.project.model.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    private static final String MESSAGE = "Welcome to IT academy project Backend, team 4!";

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Message hello() {
        Message message = new Message();
        message.setMessage(MESSAGE);
        return message;
    }

}
