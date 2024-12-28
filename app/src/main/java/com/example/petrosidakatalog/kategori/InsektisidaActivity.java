package com.example.petrosidakatalog.kategori;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.petrosidakatalog.DetailProdukActivity;
import com.example.petrosidakatalog.R;
import com.example.petrosidakatalog.adapter.ProdukAdapter;
import com.example.petrosidakatalog.adapter.RecyclerItemClickListener;
import com.example.petrosidakatalog.sqlite.DatabaseHelper;
import com.example.petrosidakatalog.sqlite.Produk;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InsektisidaActivity extends AppCompatActivity {

    // Inisialisasi variabel
    DatabaseHelper db;
    List<Produk> produkList = new ArrayList<Produk>();
    RecyclerView rvProduk;
    ProdukAdapter produkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insektisida);

        // Inisialisasi basis data
        db = new DatabaseHelper(getApplicationContext());
        try {
            db.createDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        db.openDatabase();

        // Membaca daftar produk dari database
        produkList = db.getProdukByKategori(2);

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
    }
}