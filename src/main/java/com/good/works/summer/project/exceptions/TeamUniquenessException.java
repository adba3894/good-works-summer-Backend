package com.good.works.summer.project.exceptions;

public class TeamUniquenessException extends Exception{

    public TeamUniquenessException(){
        super("Team with same data already exists!");
    }

}
