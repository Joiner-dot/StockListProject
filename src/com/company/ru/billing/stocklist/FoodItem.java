package com.company.ru.billing.stocklist;

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
        this (name, price, null, null, expires);
    }

    public FoodItem (String name){
        this (name, 0, null, null, (short) 0);
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
    public void printAll (){
        super.printAll ();
        System.out.println (dateOfIncome + " " + expires);
    }

    public boolean equals (Object o){
        if (o instanceof FoodItem)
            return super.equals (o) && this.analog.equals (o) && this.dateOfIncome.equals (o) && this.expires == ((FoodItem) o).expires;
        else return false;
    }

    @Override
    public int hashCode (){
        int result = 1;
        result = 30 * result + getID ();
        result = 30 * result + getCurrentID ();
        result = 30 * result + getName ().hashCode ();
        result = (int) (30 * result + (int) getPrice () + getPrice () % 1);
        result = 30 * result + analog.hashCode ();
        result = 30 * result + Category.values ().hashCode ();
        result = 30 * result + dateOfIncome.hashCode ();
        result = 30 * result + expires;

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
