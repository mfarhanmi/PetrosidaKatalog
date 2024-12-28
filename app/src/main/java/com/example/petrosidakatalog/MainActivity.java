package com.example.petrosidakatalog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petrosidakatalog.kategori.AkarisidaActivity;
import com.example.petrosidakatalog.kategori.AllProdukActivity;
import com.example.petrosidakatalog.kategori.BenihActivity;
import com.example.petrosidakatalog.kategori.BioActivity;
import com.example.petrosidakatalog.kategori.FungisidaActivity;
import com.example.petrosidakatalog.kategori.HerbisidaActivity;
import com.example.petrosidakatalog.kategori.InsektisidaActivity;
import com.example.petrosidakatalog.kategori.PupukActivity;
import com.example.petrosidakatalog.kategori.RodentisidaActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity  {

    //View Nama USer
    private FirebaseUser firebaseUser;
    private TextView textName;

    SliderView sliderView;
    int[] images = {R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
            R.drawable.banner4};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase Display
        textName = findViewById(R.id.user);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser!=null) {
            textName.setText(firebaseUser.getDisplayName());
        } else {
            textName.setText("Login Gagal");
        }

        //Slide View
        sliderView = findViewById(R.id.image_slader);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        //Set Click Button
        Button button1 = findViewById(R.id.btnAllProduk);
        Button button2 = findViewById(R.id.btnHerbisida);
        Button button3 = findViewById(R.id.btnInsektisida);
        Button button4 = findViewById(R.id.btnAkarisida);
        Button button5 = findViewById(R.id.btnFungisida);
        Button button6 = findViewById(R.id.btnRodentisida);
        Button button7 = findViewById(R.id.btnPupuk);
        Button button8 = findViewById(R.id.btnBenih);
        Button button9 = findViewById(R.id.btnBio);

        button1.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), AllProdukActivity.class));
        });

        button2.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), HerbisidaActivity.class));
        });
//
        button3.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), InsektisidaActivity.class));
        });

        button4.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), AkarisidaActivity.class));
        });

        button5.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), FungisidaActivity.class));
        });

        button6.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), RodentisidaActivity.class));
        });

        button7.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), PupukActivity.class));
        });

        button8.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BenihActivity.class));
        });

        button9.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BioActivity.class));
        });



        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    overridePendingTransition(0, 0);
                    break;
                case R.id.favorite:
                    Intent intent1 = new Intent(MainActivity.this, Favorite.class);
                    startActivity(intent1);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.store:
                    Intent intent2 = new Intent(MainActivity.this, Store.class);
                    startActivity(intent2);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.contact:
                    Intent intent3 = new Intent(MainActivity.this, Contact.class);
                    startActivity(intent3);
                    overridePendingTransition(0, 0);
                    break;
            }
            return false;
        });
    }


    @Override
    public void onBackPressed() {
//        Mengaktifkan Pemberitahuan saat ingin menutup aplikasi
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Apakah anda yakin keluar dari aplikasi ini ?");
        builder.setCancelable(true);
        builder.setNegativeButton("Tidak", (dialogInterface, i) -> dialogInterface.cancel());
        builder.setPositiveButton("Ya", (dialog, i) -> finish());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        FirebaseAuth.getInstance().signOut();

    }
}