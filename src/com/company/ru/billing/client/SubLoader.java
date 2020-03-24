package com.company.ru.billing.client;

import com.company.ru.billing.stocklist.FoodItem;
import com.company.ru.billing.stocklist.GenericItem;
import com.company.ru.billing.stocklist.GenericItem.Category;
import com.company.ru.billing.stocklist.ItemCatalog;
import com.company.ru.itmo.exceptions.CatalogLoadExceptions;
import com.company.ru.itmo.exceptions.ItemAlreadyExistsException;

import java.util.Date;

public class SubLoader implements CatalogLoader{
    @Override
    public void load (ItemCatalog itemCatalog) throws CatalogLoadExceptions{
        GenericItem item1 = new GenericItem ("КОркунов", 10f, Category.GENERAL);
        GenericItem item2 = new FoodItem ("Продукт3", 45, null, new Date (), (short) 120);
        try{
            itemCatalog.addItem (item1);
            itemCatalog.addItem (item2);
        } catch (ItemAlreadyExistsException e){
            e.printStackTrace ();
            throw new CatalogLoadExceptions (e);
        }
    }
}
