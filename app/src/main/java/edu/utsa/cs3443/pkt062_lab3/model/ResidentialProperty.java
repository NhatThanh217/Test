package edu.utsa.cs3443.pkt062_lab3.model;

public class ResidentialProperty extends edu.utsa.cs3443.pkt062_lab3.model.Property {
    private double hoaFees;
    private int numberOfBedroom;
    private double numberOfBathroom;

    /**
     * Constructor ResidentialProperty
     * @param ID
     * @param location
     * @param price
     * @param hoaFees
     * @param numberOfBedroom
     * @param numberOfBathroom
     */
    public  ResidentialProperty (String ID , String location, double price, double hoaFees, int numberOfBedroom, double numberOfBathroom){
        super(ID, location, price);
        this.hoaFees = hoaFees;
        this.numberOfBedroom = numberOfBedroom;
        this.numberOfBathroom = numberOfBathroom;
    }

    /**
     *
     * getter and setter method
     */
    public double getHoaFees() {
        return hoaFees;
    }

    public void setHoaFees(double hoaFees) {
        this.hoaFees = hoaFees;
    }

    public double getNumberOfBedroom() {
        return numberOfBedroom;
    }

    public void setNumberOfBedroom(int numberOfBedroom) {
        this.numberOfBedroom = numberOfBedroom;
    }

    public void setNumberOfBathroom(double numberOfBathroom) {
        this.numberOfBathroom = numberOfBathroom;
    }

    public double getNumberOfBathroom() {
        return numberOfBathroom;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString(){

        return super.toString()+"\n Annual Hoa Fees: " +hoaFees +"\n Bedrooms: "+numberOfBedroom +"\nBathrooms: "+numberOfBathroom;
    }
}
