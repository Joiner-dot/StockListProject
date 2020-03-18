package com.company.ru.billing.stocklist;

public class GenericItem{
    public enum Category{FOOD, PRINT, DRESS, GENERAL}

    public GenericItem (String name, float price, Category category){
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.category = category;
        if (GenericItem.currentID < this.ID){
            GenericItem.currentID = this.ID;
        }
    }

    public GenericItem (String name, float price, GenericItem analog){
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.analog = analog;
        if (GenericItem.currentID < this.ID){
            GenericItem.currentID = this.ID;
        }
    }

    public GenericItem (){
        this.ID = GenericItem.currentID++;
        this.analog = null;
        this.category = null;
        this.price = 0f;
        this.name = null;
        if (GenericItem.currentID < this.ID){
            GenericItem.currentID = this.ID;
        }
    }

    public int getID (){
        return ID;
    }

    public void setID (int ID){
        this.ID = ID;
    }

    public static int getCurrentID (){
        return currentID;
    }

    public static void setCurrentID (int currentID){
        GenericItem.currentID = currentID;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public float getPrice (){
        return price;
    }

    public void setPrice (float price){
        this.price = price;
    }

    public GenericItem getAnalog (){
        return analog;
    }

    public void setAnalog (GenericItem analog){
        this.analog = analog;
    }

    public Category getCategory (){
        return category;
    }

    public void setCategory (Category category){
        this.category = category;
    }

    private int ID;
    private static int currentID;
    private String name;
    private float price;
    private GenericItem analog;
    private Category category = Category.GENERAL;

    public void printAll (){
        System.out.printf ("ID: %d, Name: %s, price:%5.2f, category: %s \n", ID, name, price, category);
    }

    public boolean equals (Object o){
        if (o instanceof GenericItem)
            return ((GenericItem) o).getName ().equals (this.name) && ((GenericItem) o).category == this.category;
        else
            return false;
    }


    @Override
    public int hashCode (){
        int result = 1;
        result = 30 * result + ID;
        result = 30 * result + currentID;
        if (name != null){
            result = 30 * result + name.hashCode ();
        } else{
            result = 30 * result;
        }
        if (price != 0){
            result = (int) (30 * result + (int) price);
            result = (int) (30 * result + (int) (price % 1));
        } else
            result = 30 * result;
        if (analog != null){
            result = 30 * result + analog.hashCode ();
        } else
            result = 30 * result;
        if (category != null){
            result = 30 * result + category.hashCode ();
        } else
            result = 30 * result;
        return result;
    }

    public GenericItem clone (){
        GenericItem o = new GenericItem ();
        o.setName (this.getName ());
        o.setPrice (this.getPrice ());
        o.setAnalog (this.getAnalog ());
        o.setID (this.getID ());
        o.setCategory (this.getCategory ());
        return o;
    }

    public String toString (){
        String line = " " + this.name + " " + this.price + " " + this.ID + " " + this.category;
        return line;
    }
}
