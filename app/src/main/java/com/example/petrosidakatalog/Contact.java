package com.example.petrosidakatalog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Contact extends AppCompatActivity {

    Button sendEmailButton;
    EditText emailAddress;
    EditText emailSubject;
    EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        emailAddress = findViewById(R.id.email);
        emailSubject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        sendEmailButton = findViewById(R.id.send_button);

        sendEmailButton.setOnClickListener(view -> {
            String toemailAddress = emailAddress.getText().toString();
            String msubject = emailSubject.getText().toString();
            String mmessage = message.getText().toString();

            Intent emailApp = new Intent(Intent.ACTION_SEND);
            emailApp.putExtra(Intent.EXTRA_EMAIL, new String[]{toemailAddress});
            emailApp.putExtra(Intent.EXTRA_SUBJECT, msubject);
            emailApp.putExtra(Intent.EXTRA_TEXT, mmessage);
            emailApp.setType("message/rfc822");
            startActivity(Intent.createChooser(emailApp, "Send Email Via"));

        });

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.contact);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    Intent intent0 = new Intent(Contact.this, MainActivity.class);
                    startActivity(intent0);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.favorite:
                    Intent intent1 = new Intent(Contact.this, Favorite.class);
                    startActivity(intent1);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.store:
                    Intent intent2 = new Intent(Contact.this, Store.class);
                    startActivity(intent2);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.contact:
                    overridePendingTransition(0, 0);
                    break;
            }
            return false;
        });
    }
}