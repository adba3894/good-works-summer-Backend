package com.good.works.summer.project.exceptions;

public class UniqueTeamException extends Exception{

    public UniqueTeamException(){
        super("Team with same data already exists!");
    }

}
