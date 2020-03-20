package com.company.ru.billing.client;

import com.company.ru.billing.stocklist.FoodItem;
import com.company.ru.billing.stocklist.ItemCatalog;
import com.company.ru.itmo.exceptions.CatalogLoadExceptions;
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
    public void load (ItemCatalog itemCatalog) throws CatalogLoadExceptions, IOException{
        File f = new File (fileName);
        FileInputStream stream = null;
        String line;

        try{
            stream = new FileInputStream (f);
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
            stream.close ();
        } catch (FileNotFoundException e){
            stream.close ();
            e.printStackTrace ();

        } catch (ItemAlreadyExistsException e){
            stream.close ();
            e.printStackTrace ();
        }
    }
//Чтение из файла с кодировкой UTF-8
    public void utf8load (ItemCatalog itemCatalog) throws CatalogLoadExceptions, IOException{
        BufferedReader in = null;
        try{
            File fileDir = new File (fileName);

            in = new BufferedReader (
                    new InputStreamReader (
                            new FileInputStream (fileDir), "UTF8"));

            String line;

            while ((line = in.readLine ()) != null){
                String[] items = line.split (";");
                String name = items[0];
                float price = Float.parseFloat (items[1]);
                short expires = Short.parseShort (items[2]);
                FoodItem item = new FoodItem (name, price, null, new Date (), expires);
                itemCatalog.addItem (item);
            }

            in.close ();
        } catch (UnsupportedEncodingException e){
            in.close ();
            e.printStackTrace ();
        } catch (IOException e){
            in.close ();
            e.printStackTrace ();
        } catch (ItemAlreadyExistsException e){
            in.close ();
            e.printStackTrace ();
        }
    }
//Чтение из файла с кодировкой Windows-1251
    public void windows1251load (ItemCatalog itemCatalog) throws CatalogLoadExceptions, IOException{
        BufferedReader in = null;
        try{
            File fileDir = new File (fileName);
            in = new BufferedReader (
                    new InputStreamReader (
                            new FileInputStream (fileDir), "UTF-8"));
            String line;
            while ((line = in.readLine ()) != null){
                String str = new String (line.getBytes ("windows-1251"));
                System.out.println (str);
                String[] items = str.split (";");
                String name = items[0];
                float price = Float.parseFloat (items[1]);
                short expires = Short.parseShort (items[2]);
                FoodItem item = new FoodItem (name, price, null, new Date (), expires);
                itemCatalog.addItem (item);
            }
            in.close ();
        } catch (UnsupportedEncodingException e){
            in.close ();
            e.printStackTrace ();
        } catch (IOException e){
            e.printStackTrace ();
        } catch (ItemAlreadyExistsException e){
            in.close ();
            e.printStackTrace ();
        }
    }
}
