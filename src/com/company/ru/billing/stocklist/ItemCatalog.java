package com.company.ru.billing.stocklist;

import com.company.ru.itmo.exceptions.ItemAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog{

    private HashMap<Integer, Item> catalog =
            new HashMap<Integer, Item> ();
    private ArrayList<Item> ALCatalog =
            new ArrayList<> ();

    public void addItem (GenericItem item) throws ItemAlreadyExistsException{
        try{
            for (Item item1 : ALCatalog){
                if (item1.equals (item)){
                    throw new ItemAlreadyExistsException ();
                }
            }
            catalog.put (item.getID (), item); // Добавляем товар в HashMap
            ALCatalog.add (item); // Добавляем тот же товар в ArrayList
        } catch (ItemAlreadyExistsException e){
            throw e;
        }
    }

    public void printItem (){
        for (Item i : ALCatalog){
            System.out.println (i.toString ());
        }
    }

    public Item findItemByID (int id){
        return catalog.getOrDefault (id, null);
    }

    public Item findItemByIDAL (int id){
        for (Item i : ALCatalog){
            if (i.getID () == id) return i;
        }
        return null;
    }

}
