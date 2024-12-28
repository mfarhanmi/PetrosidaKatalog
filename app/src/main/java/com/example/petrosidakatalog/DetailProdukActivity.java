package com.example.petrosidakatalog;

import android.content.res.Resources;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.petrosidakatalog.sqlite.DatabaseHelper;
import com.example.petrosidakatalog.sqlite.Produk;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DetailProdukActivity extends AppCompatActivity {

    TextView tvProdukJenis, tvProdukDeskripsi, tvProdukKeunggulan, tvProdukDetail, tvProdukPetunjuk;
    ImageView ivProdukCover, ivGambarLain;
    Produk produk;
    DatabaseHelper db;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (db.isFavorit(produk.getProdukId())) {
                    db.deleteFavorit(produk.getProdukId());
                    Snackbar.make(view, "Produk berhasil dihapus dari Favorit", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    fab.setImageResource(android.R.drawable.btn_star_big_off);
                } else {
                    db.addFavorit(produk.getProdukId());
                    Snackbar.make(view, "Produk berhasil ditambahkan ke dalam Favorit", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    fab.setImageResource(android.R.drawable.btn_star_big_on);
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Mendapatkan objek produk dari MainActivity
        produk = (Produk) getIntent().getSerializableExtra("produk");
        getSupportActionBar().setTitle(produk.getProdukNama());

        // Mendapatkan elemen view
        tvProdukJenis = (TextView)findViewById(R.id.tvProdukJenis);
        tvProdukDeskripsi = (TextView)findViewById(R.id.tvProdukDeskripsi);
        tvProdukKeunggulan = (TextView)findViewById(R.id.tvProdukKeunggulan);
        tvProdukDetail = (TextView)findViewById(R.id.tvProdukDetail);
        tvProdukPetunjuk = (TextView)findViewById(R.id.tvProdukpetunjuk);
        ivProdukCover = (ImageView) findViewById(R.id.ivProdukCover);
        ivGambarLain = (ImageView)findViewById(R.id.ivGambarLain);


        // Mengeset elemen view
        tvProdukJenis.setText(produk.getProdukJenis());
        tvProdukDeskripsi.setText(produk.getProdukDeskripsi());
        tvProdukKeunggulan.setText(produk.getProdukKeunggulan());
        tvProdukDetail.setText(produk.getProdukDetail());
        tvProdukPetunjuk.setText(produk.getProdukPetunjuk());

        Resources res = getBaseContext().getResources();
        String mDrawableName = produk.getProdukGambar();
        int resId = res.getIdentifier(mDrawableName, "drawable", getBaseContext().getPackageName());
        ivProdukCover.setImageResource(resId);

        Resources res1 = getBaseContext().getResources();
        String mDrawableName1 = produk.getGambarLain();
        int res1Id = res1.getIdentifier(mDrawableName1, "drawable", getBaseContext().getPackageName());
        ivGambarLain.setImageResource(res1Id);

        // Menghubungkan dengan basis data
        db = new DatabaseHelper(getApplicationContext());
        db.openDatabase();

        // Mengeset ikon Favorit
        if (db.isFavorit(produk.getProdukId())) {
            fab.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            fab.setImageResource(android.R.drawable.btn_star_big_off);
        }
    }

}
