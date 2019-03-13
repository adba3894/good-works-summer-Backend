package com.good.works.summer.project.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



//paskui pasitart
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TeamSizeException extends Exception {
    public TeamSizeException() {
        super("There already are five teams in the city");
    }
}
