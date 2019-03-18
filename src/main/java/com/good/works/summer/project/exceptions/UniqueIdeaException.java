package com.good.works.summer.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UniqueIdeaException extends Exception {

    public UniqueIdeaException() {
        super("Idea with same description exists!");
    }
}
