package com.company.ru.billing.client;

import com.company.ru.billing.stocklist.FoodItem;
import com.company.ru.billing.stocklist.GenericItem;
import com.company.ru.billing.stocklist.GenericItem.Category;
import com.company.ru.billing.stocklist.ItemCatalog;
import com.company.ru.itmo.exceptions.CatalogLoadExceptions;
import com.company.ru.itmo.exceptions.ItemAlreadyExistsException;

import java.io.IOException;
import java.util.Date;

public class Main{
    //CatalogFileLoader для 6 лабораторной
    public static void main (String[] args) throws IOException{
        ItemCatalog itemCatalog = new ItemCatalog ();
        CatalogFileLoader file = new CatalogFileLoader ("src/com/company/Readme.txt");
        try{
            file.load (itemCatalog);
        } catch (CatalogLoadExceptions | IOException catalogLoadExceptions){
            catalogLoadExceptions.printStackTrace ();
        }

        itemCatalog.printItem ();

    }
}
