package edu.utsa.cs3443.pkt062_lab3.model;

public class CommercialProperty extends edu.utsa.cs3443.pkt062_lab3.model.Property {
    private String zone;
    private int numberOfUnit;
    private int numberOfParking;

    /**
     * Constructor CommercialProperty
     * @param ID
     * @param location
     * @param price
     * @param zone
     * @param numberOfUnit
     * @param numberOfParking
     */
    public CommercialProperty (String ID , String location, double price, String zone, int numberOfUnit, int numberOfParking){
        super(ID, location, price);
        this.zone = zone;
        this.numberOfUnit = numberOfUnit;
        this.numberOfParking = numberOfParking;
    }

    /**
     *
     * getter and setter method
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getZone() {
        return zone;
    }

    public int getNumberOfUnit() {
        return numberOfUnit;
    }

    public void setNumberOfUnit(int numberOfUnit) {
        this.numberOfUnit = numberOfUnit;
    }

    public int getNumberOfParking() {
        return numberOfParking;
    }

    public void setNumberOfParking(int numberOfParking) {
        this.numberOfParking = numberOfParking;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString(){
        return super.toString()+"\nZone: "+zone+"\nUnits: "+numberOfUnit +"\nParking Spot: "+ numberOfParking;
    }
}


