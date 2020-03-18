package com.company.ru.billing.stocklist;

import com.company.ru.itmo.exceptions.ItemAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog{

    private HashMap<Integer, GenericItem> catalog =
            new HashMap<Integer, GenericItem> ();
    private ArrayList<GenericItem> ALCatalog =
            new ArrayList<GenericItem> ();

    public void addItem (GenericItem item) throws ItemAlreadyExistsException{
        try{
            for (GenericItem item1 : ALCatalog){
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
        for (GenericItem i : ALCatalog){
            System.out.println (i.toString ());
        }
    }

    public GenericItem findItemByID (int id){
        if (!catalog.containsKey (id)){
            return null;
        } else{
            return catalog.get (id);
        }
    }

    public GenericItem findItemByIDAL (int id){
        for (GenericItem i : ALCatalog){
            if (i.getID () == id) return i;
        }
        return null;
    }

}
