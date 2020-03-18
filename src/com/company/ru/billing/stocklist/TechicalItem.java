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
        int result = 1;
        result = 30 * result + getID ();
        result = 30 * result + getCurrentID ();
        result = 30 * result + getName ().hashCode ();
        result = (int) (30 * result + (int) getPrice () + getPrice () % 1);
        result = 30 * result + analog.hashCode ();
        result = 30 * result + Arrays.hashCode (Category.values ());
        result = 30 * result + warrantyTime;
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
