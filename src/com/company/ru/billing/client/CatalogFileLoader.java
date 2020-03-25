package com.company.ru.billing.client;

import com.company.ru.billing.stocklist.FoodItem;
import com.company.ru.billing.stocklist.GenericItem;
import com.company.ru.billing.stocklist.ItemCatalog;
import com.company.ru.itmo.exceptions.ItemAlreadyExistsException;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

//класс для сдачи лабы 6
public class CatalogFileLoader implements CatalogLoader{

    private String fileName;

    public CatalogFileLoader (String fileName){
        this.fileName = fileName;
    }

    //Чтение из файла и добавление продукта
    @Override
    public void load (ItemCatalog itemCatalog) throws IOException{
        File f = new File (fileName);
        String line;

        try (FileInputStream stream = new FileInputStream (f)){
            Scanner scanner = new Scanner (stream);
            while (scanner.hasNextLine ()){
                line = scanner.nextLine ();
                if (line.length () == 0){
                    break;
                }
                String[] items = line.split (";");
                String name = items[0];
                float price = Float.parseFloat (items[1]);
                short expires = Short.parseShort (items[2]);
                FoodItem item = new FoodItem (name, price, null, new Date (), expires);
                itemCatalog.addItem (item);
            }
        } catch (ItemAlreadyExistsException e){
            e.printStackTrace ();
        }
    }

    //Чтение из файла с кодировкой UTF-8
    public void utf8load (ItemCatalog itemCatalog) throws IOException{
        File fileDir = new File (fileName);

        try (BufferedReader in = new BufferedReader (
                new InputStreamReader (
                        new FileInputStream (fileDir)))){
            String line;
            while ((line = in.readLine ()) != null){
                String str = new String (line.getBytes ("windows-1251"));
                String[] items = str.split (";");
                String name = items[0];
                float price = Float.parseFloat (items[1]);
                short expires = Short.parseShort (items[2]);
                GenericItem item = new FoodItem (name, price, null, new Date (), expires);
                itemCatalog.addItem (item);
            }
        } catch (ItemAlreadyExistsException e){
            e.printStackTrace ();
        }
    }

    //Чтение из файла с кодировкой Windows-1251
    public void windows1251load (ItemCatalog itemCatalog) throws IOException{

        File fileDir = new File (fileName);
        try (BufferedReader in = new BufferedReader (
                new InputStreamReader (
                        new FileInputStream (fileDir)))){
            String line;
            while ((line = in.readLine ()) != null){
                String str = new String (line.getBytes ("windows-1251"));
                String[] items = str.split (";");
                String name = items[0];
                float price = Float.parseFloat (items[1]);
                short expires = Short.parseShort (items[2]);
                GenericItem item = new FoodItem (name, price, null, new Date (), expires);
                itemCatalog.addItem (item);
            }
        } catch (ItemAlreadyExistsException e){
            e.printStackTrace ();
        }
    }
}
