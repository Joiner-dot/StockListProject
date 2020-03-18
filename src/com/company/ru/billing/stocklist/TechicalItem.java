package com.company.ru.billing.stocklist;

import java.util.Arrays;

public class TechicalItem extends GenericItem{
    public short getWarrantyTime (){
        return warrantyTime;
    }

    public void setWarrantyTime (short warrantyTime){
        this.warrantyTime = warrantyTime;
    }

    short warrantyTime;

    @Override
    public TechicalItem getAnalog (){
        return analog;
    }

    public void setAnalog (TechicalItem analog){
        this.analog = analog;
    }

    private TechicalItem analog;

    @Override
    public void printAll (){
        super.printAll ();
        System.out.println (warrantyTime);
    }

    public boolean equals (Object o){
        if (o instanceof TechicalItem){
            return super.equals (o) && ((TechicalItem) o).getWarrantyTime () == this.getWarrantyTime ();
        } else return false;
    }

    @Override
    public int hashCode (){
        int result = super.hashCode ();
        if (warrantyTime != 0)
            result = result * 30 + warrantyTime;
        else
            result *= 30;
        return result;
    }

    @Override
    public TechicalItem clone (){
        TechicalItem o = new TechicalItem ();
        o.setName (this.getName ());
        o.setPrice (this.getPrice ());
        o.setAnalog (this.getAnalog ());
        o.setID (this.getID ());
        o.setCategory (this.getCategory ());
        o.setWarrantyTime (this.getWarrantyTime ());
        return o;
    }
}
