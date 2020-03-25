package com.company.ru.billing.stocklist;

import java.lang.String;

import java.util.Date;

public class FoodItem extends GenericItem{

    public FoodItem (String name, float price, FoodItem analog, Date date, short expires){
        this.setName (name);
        this.setPrice (price);
        this.setAnalog (analog);
        this.dateOfIncome = date;
        this.expires = expires;
    }

    public FoodItem (String name, float price, short expires){
        this (name, price, null, new Date (), expires);
    }

    public FoodItem (String name){
        this (name, 0, null, new Date (), (short) 0);
    }

    public Date getDateOfIncome (){
        return dateOfIncome;
    }

    public void setDateOfIncome (Date dateOfIncome){
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires (){
        return expires;
    }

    public void setExpires (short expires){
        this.expires = expires;
    }

    private Date dateOfIncome; // дата производства
    private short expires;
    private FoodItem analog;

    @Override
    public FoodItem getAnalog (){
        return analog;
    }

    public void setAnalog (FoodItem analog){
        this.analog = analog;
    }

    @Override
    public void printall (){
        super.printall ();
        System.out.println (dateOfIncome + " " + expires);
    }

    public boolean equals (Object o){
        try{
            if (o instanceof FoodItem){
                return super.equals (o) && this.getAnalog ().equals (((FoodItem) o).getAnalog ()) && this.dateOfIncome.equals (o) && this.expires == ((FoodItem) o).expires;
            } else return false;
        } catch (NullPointerException e){
            return super.equals (o) && this.analog == null && ((FoodItem) o).analog == null && this.dateOfIncome.equals (((FoodItem) o).dateOfIncome) && this.expires == ((FoodItem) o).expires;
        }
    }

    @Override
    public int hashCode (){
        int result = super.hashCode ();
        if (dateOfIncome != null)
            result = 30 * result + dateOfIncome.hashCode ();
        else
            result = 30 * result;
        if (expires != 0)
            result = 30 * result + expires;
        else
            result = 30 * result;
        return result;
    }

    @Override
    public FoodItem clone (){
        FoodItem o = new FoodItem ("Пушка");
        o.setName (this.getName ());
        o.setPrice (this.getPrice ());
        o.setAnalog (this.getAnalog ());
        o.setDateOfIncome (this.getDateOfIncome ());
        o.setExpires (this.getExpires ());
        o.setID (this.getID ());
        o.setCategory (this.getCategory ());
        return o;
    }
}
