package edu.utsa.cs3443.pkt062_lab3.model;

public abstract class Property {

    private String ID;
    private String location;
    private double price;


    /**
     * Constructor Property
     * @param ID
     * @param location
     * @param price
     */
    public Property (String ID, String location, double price){

        this.ID = ID;
        this.location = location;
        this.price = price;
    }

    /**
     *
     * getter and setter method
     */
    public  String getID(){
        return  this.ID;
    }
    public void setID(String ID){
        this.ID =  ID;
    }

    public  String getLocation(){
        return  this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public double getPrice(){
        return  this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    /**
     *
     * @return String
     */
    public String toString(){
        return "ID: "+ID +"\nLocation: "+location + "\nPrice: "+price;
    }
}
