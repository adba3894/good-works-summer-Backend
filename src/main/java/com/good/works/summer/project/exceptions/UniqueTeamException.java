package com.good.works.summer.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UniqueTeamException extends Exception{

    public UniqueTeamException(){
        super("Team with same data already exists!");
    }

}
