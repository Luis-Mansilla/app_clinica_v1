package com.example.clinica_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToActivity_principal(View view) {
        Intent activity0 = new Intent(this, eliminar.class);
        startActivity(activity0);
    }

    public void goToActivity_recepcionista(View view) {
        Intent activity1 = new Intent(this, recepcionista.class);
        startActivity(activity1);
    }

    public void goToActivity_tecnico(View view) {
        Intent activity2 = new Intent(this, tecnico.class);
        startActivity(activity2);


    }
}