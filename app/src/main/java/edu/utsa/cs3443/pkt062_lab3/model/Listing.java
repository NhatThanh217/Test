package edu.utsa.cs3443.pkt062_lab3.model;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.pkt062_lab3.MainActivity;

public class Listing   {

    private ArrayList<Property> properties;

    /**
     * constructor Listing
     */
    public Listing() {
        properties = new ArrayList<>();

    }

    /**
     *Load the information of properties from file.csv
     * @param activity
     */

    public void loadProperties(MainActivity activity) {
        AssetManager manager = activity.getAssets();
        try {
            InputStream inputStream = manager.open("listings.csv");
            Scanner scan = new Scanner(inputStream);

            while (scan.hasNext()) {
                String[] lineSplit = scan.nextLine().trim().split(",");

                    String id = lineSplit[0];
                    String location = lineSplit[1];
                    double price = Double.parseDouble(lineSplit[2]);

                    if (id.startsWith("rp")) {
                        double hoaFees = Double.parseDouble(lineSplit[3]);
                        int bedrooms = Integer.parseInt(lineSplit[4]);
                        double bathrooms = Double.parseDouble(lineSplit[5]);
                        properties.add(new ResidentialProperty(id, location, price, hoaFees, bedrooms, bathrooms));
                    } else if (id.startsWith("cp")) {
                        String zone = lineSplit[3];
                        int units = Integer.parseInt(lineSplit[4]);
                        int parkingSpots = Integer.parseInt(lineSplit[5]);
                        properties.add(new CommercialProperty(id, location, price, zone, units, parkingSpots));
                    }
                }

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return ArrayList
     */
    public ArrayList<Property> getProperties(){
        return  this.properties;
    }

    /**
     * SetProperties method
     * @param properties
     */
    public  void setProperties(ArrayList<Property>properties){
        this.properties = properties;
    }

    /**
     * add Property method
     * @param property
     */
    public void addProperty(Property property){
        this.properties.add(property);
    }

    /**
     *
     * @param index
     * @return Property
     */
    public Property getProperty(int index){
        return properties.get(index);
    }
    /**
     *
     * @param Id
     * @return Property
     */
    public Property getProperty(String Id) {
        for (Property property : properties) {
            if (property.getID().equals(Id)) {
                return property;
            }
        }
        return null; // Property not found
    }

}
