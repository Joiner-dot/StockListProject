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
        String line = "Конфеты ’Маска’;45;120";
        String[] valuelist = line.split (";");
        FoodItem foodItem = new FoodItem (valuelist[0], Float.parseFloat (valuelist[1]), Short.parseShort (valuelist[2]));
        foodItem.printAll ();
        ItemCatalog itemCatalog = new ItemCatalog ();
        try{
            itemCatalog.addItem (new GenericItem ("КОркунов", 10f, Category.GENERAL));
        } catch (ItemAlreadyExistsException e){
            e.printStackTrace ();
        }

        long begin = new Date ().getTime ();
        for (int i = 0; i < 100000; i++)
            itemCatalog.findItemByID (5);
        long end = new Date ().getTime ();
        System.out.println ("HashMap Time = " + (int) (end - begin));
        begin = new Date ().getTime ();
        for (int i = 0; i < 100000; i++)
            itemCatalog.findItemByIDAL (5);
        end = new Date ().getTime ();
        System.out.println ("ArrayList Time = " + (int) (end - begin));

        CatalogLoader catalogLoader = new SubLoader ();
        try{
            catalogLoader.load (itemCatalog);
        } catch (CatalogLoadExceptions e){
            System.out.println (e.getName ());
            e.printStackTrace ();
        }
        CatalogFileLoader file = new CatalogFileLoader ("/Users/egor_kuzmin/IdeaProjects/StockListProject/src/com/company/Readme.txt");
        try{
            file.load (itemCatalog);
        } catch (CatalogLoadExceptions | IOException catalogLoadExceptions){
            catalogLoadExceptions.printStackTrace ();
        }

        itemCatalog.printItem ();

    }
}
