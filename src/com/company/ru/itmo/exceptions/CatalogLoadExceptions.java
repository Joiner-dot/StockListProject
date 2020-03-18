package com.company.ru.itmo.exceptions;


public class CatalogLoadExceptions extends Exception{
    public CatalogLoadExceptions (ItemAlreadyExistsException e){
        this.name = "O my garable";
    }

    public String getName (){
        return name;
    }

    private String name;
}
