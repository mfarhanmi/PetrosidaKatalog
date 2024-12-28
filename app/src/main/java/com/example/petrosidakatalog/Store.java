package com.example.petrosidakatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Store extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.store);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    Intent intent0 = new Intent(Store.this, MainActivity.class);
                    startActivity(intent0);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.favorite:
                    Intent intent1 = new Intent(Store.this, Favorite.class);
                    startActivity(intent1);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.store:
                    overridePendingTransition(0, 0);
                    break;
                case R.id.contact:
                    Intent intent3 = new Intent(Store.this, Contact.class);
                    startActivity(intent3);
                    overridePendingTransition(0, 0);
                    break;
            }
            return false;
        });
    }
}