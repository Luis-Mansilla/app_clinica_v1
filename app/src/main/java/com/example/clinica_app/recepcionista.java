package com.example.clinica_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class recepcionista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcionista);
    }
    public void goToActivity_ingreso(View view){
        Intent activity2 = new Intent(this, ingreso.class);
        startActivity(activity2);
    }
}