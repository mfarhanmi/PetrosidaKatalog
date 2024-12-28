package com.example.petrosidakatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.petrosidakatalog.adapter.ProdukAdapter;
import com.example.petrosidakatalog.adapter.RecyclerItemClickListener;
import com.example.petrosidakatalog.sqlite.DatabaseHelper;
import com.example.petrosidakatalog.sqlite.Produk;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Favorite extends AppCompatActivity {

    // Inisialisasi variabel
    DatabaseHelper db;
    List<Produk> produkList = new ArrayList<Produk>();
    RecyclerView rvProduk;
    ProdukAdapter produkAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        // Inisialisasi basis data
        db = new DatabaseHelper(getApplicationContext());
        try {
            db.createDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        db.openDatabase();

        // Membaca daftar produk dari database
        produkList = db.getAllProdukFavorit();

        // Mengeset adapter
        produkAdapter = new ProdukAdapter(produkList, getApplicationContext());

        // Mengeset recycler view
        rvProduk = (RecyclerView) findViewById(R.id.rvProduk);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        rvProduk.setLayoutManager(mLayoutManager);
        rvProduk.setAdapter(produkAdapter);

        // Menambahkan fungsi klik pada item RecyclerView
        rvProduk.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), (view, position) -> {

                    Intent intent = new Intent(getApplicationContext(), DetailProdukActivity.class);
                    intent.putExtra("produk", (Serializable) produkList.get(position));
                    startActivity(intent);

                })
        );


        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.favorite);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    Intent intent0 = new Intent(Favorite.this, MainActivity.class);
                    startActivity(intent0);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.favorite:
                    overridePendingTransition(0, 0);
                    break;
                case R.id.store:
                    Intent intent2 = new Intent(Favorite.this, Store.class);
                    startActivity(intent2);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.contact:
                    Intent intent3 = new Intent(Favorite.this, Contact.class);
                    startActivity(intent3);
                    overridePendingTransition(0, 0);
                    break;
            }
            return false;
        });
    }
}