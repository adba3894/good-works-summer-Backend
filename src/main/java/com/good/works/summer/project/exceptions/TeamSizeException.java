package com.good.works.summer.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.` `)
public class TeamSizeException extends Exception {

    public TeamSizeException() {
        super("There already are five teams in the city registered for activities from this organization");
    }
}

