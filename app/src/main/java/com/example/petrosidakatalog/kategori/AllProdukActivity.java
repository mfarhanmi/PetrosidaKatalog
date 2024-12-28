package com.example.petrosidakatalog.kategori;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

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

public class AllProdukActivity extends AppCompatActivity {

    // Inisialisasi variabel
    DatabaseHelper db;
    List<Produk> produkList = new ArrayList<Produk>();
    RecyclerView rvProduk;
    ProdukAdapter produkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_produk);

        // Inisialisasi basis data
        db = new DatabaseHelper(getApplicationContext());
        try {
            db.createDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        db.openDatabase();

        // Membaca daftar produk dari database
        produkList = db.getAllProduk();

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



//
//    @SuppressWarnings("StatementWithEmptyBody")
//
//    public boolean onItemSelected( MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_profil_perusahaan) {
//            Intent intent = new Intent(getApplicationContext(), ProfilPerusahaanActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.btnAllProduk) {
//            produkList = db.getAllProduk();
//            produkAdapter.swap(produkList);
//        } else if (id == R.id.favorite) {
//            produkList = db.getAllProdukFavorit();
//            produkAdapter.swap(produkList);
//        } else if (id == R.id.btnHerbisida) {
//            produkList = db.getProdukByKategori(1);
//            produkAdapter.swap(produkList);
//        } else if (id == R.id.btnInsektisida) {
//            produkList = db.getProdukByKategori(2);
//            produkAdapter.swap(produkList);
//        } else if (id == R.id.btnAkarisida) {
//            produkList = db.getProdukByKategori(3);
//            produkAdapter.swap(produkList);
//
//        } else if (id == R.id.btnFungisida) {
//            produkList = db.getProdukByKategori(4);
//            produkAdapter.swap(produkList);
//
//        } else if (id == R.id.btnRodentisida) {
//            produkList = db.getProdukByKategori(5);
//            produkAdapter.swap(produkList);
//
//        } else if (id == R.id.btnPupuk) {
//            produkList = db.getProdukByKategori(6);
//            produkAdapter.swap(produkList);
//
//        } else if (id == R.id.btnBenih) {
//            produkList = db.getProdukByKategori(7);
//            produkAdapter.swap(produkList);
//
//        }else if (id == R.id.btnBio) {
//            produkList = db.getProdukByKategori(8);
//            produkAdapter.swap(produkList);
//        }
//
//    }

//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextChange(String newText) {
//        produkList = db.getProdukByNama(newText);
//        produkAdapter.swap(produkList);
//        return false;
//    }
}