/**
 * @author Ho, Nhat Thanh (pkt062)
 * CS3443 Application Programing
 * Lab03
 */
package edu.utsa.cs3443.pkt062_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import edu.utsa.cs3443.pkt062_lab3.model.Listing;
import edu.utsa.cs3443.pkt062_lab3.model.Property;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Listing listing;
    private List<Button> buttons;
    private Activity activity;

    /**
     *
     */
    private void createProperty() {
        listing = new Listing();
        listing.loadProperties(this);
    }

    /**
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        Button button = (Button) v;
        String id = button.getText().toString();
        Property property = listing.getProperty(id);

        if (property != null) {
            String price = getPrice(property);
            Toast.makeText(MainActivity.this, "$" + price, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Property not found", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * getPrice method to get price of each property from file listings.csv
     * @param property
     * @return String
     */
    private String getPrice(Property property) {
        String price = String.valueOf(property.getPrice());

        List<String> prices = new ArrayList<>();
        try {
            InputStream inputStream = activity.getAssets().open("listings.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitLine = line.split(",");
                if (splitLine.length == 6) {
                    String propertyPrice = splitLine[2];
                    if (propertyPrice.equals(price)) {
                        String propertyID = splitLine[0];
                        prices.add(propertyID);
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return price;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button firstProperty = findViewById(R.id.first_location);
        Button secondProperty = findViewById(R.id.second_location);
        Button thirdProperty = findViewById(R.id.third_location);
        Button fourthProperty = findViewById(R.id.fourth_location);
        //createProperty();
        firstProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.show_first_toast,Toast.LENGTH_SHORT).show();
            }
        });
        secondProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.show_second_toast,Toast.LENGTH_SHORT ).show();
            }
        });
        thirdProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.show_third_toast,Toast.LENGTH_SHORT ).show();
            }
        }); fourthProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.show_fourth_toast,Toast.LENGTH_SHORT ).show();
            }
        });
    }

}

