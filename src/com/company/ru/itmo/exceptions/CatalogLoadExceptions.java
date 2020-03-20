package com.company.ru.itmo.exceptions;


public class CatalogLoadExceptions extends Exception{
    public CatalogLoadExceptions (ItemAlreadyExistsException e){
        this.name = "Exception of CatalogLoad";
    }

    public String getName (){
        return name;
    }

    private String name;
}
