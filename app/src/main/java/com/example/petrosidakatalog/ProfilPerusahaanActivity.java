package com.example.petrosidakatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProfilPerusahaanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_perusahaan);
        getSupportActionBar().setTitle("Profil Perusahaan");
    }
}