package com.company.ru.billing.client;

import com.company.ru.billing.stocklist.FoodItem;
import com.company.ru.billing.stocklist.GenericItem;
import com.company.ru.billing.stocklist.GenericItem.Category;
import com.company.ru.billing.stocklist.ItemCatalog;
import com.company.ru.itmo.exceptions.CatalogLoadExceptions;
import com.company.ru.itmo.exceptions.ItemAlreadyExistsException;

import java.io.IOException;
import java.util.Date;

import static com.company.ru.billing.stocklist.GenericItem.Category.*;

public class Main{
    //!!! CatalogFileLoader, ItemCatalog, CatalogLoadException,SubLoader для 6 лабораторной
    public static void main (String[] args) throws IOException{
        SubLoader subLoader = new SubLoader ();
        ItemCatalog itemCatalog = new ItemCatalog ();
        try{
            subLoader.load (itemCatalog);
        } catch (CatalogLoadExceptions catalogLoadExceptions){
            catalogLoadExceptions.printStackTrace ();
        }
        CatalogFileLoader file = new CatalogFileLoader ("src/com/company/Readme.txt");
        try{
            file.windows1251load (itemCatalog);
        } catch (CatalogLoadExceptions | IOException catalogLoadExceptions){
            catalogLoadExceptions.printStackTrace ();
        }
        itemCatalog.printItem ();

    }
}
