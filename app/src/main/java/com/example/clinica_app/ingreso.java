package com.example.clinica_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ingreso extends AppCompatActivity {

    EditText edtMain_id, edtMain_marca, edtMain_modelo, edtMain_ram,edtMain_sistema,edtMain_rut,edtMain_estado,edtMain_requerimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        edtMain_id = findViewById(R.id.edtMain_id);
        edtMain_marca = findViewById(R.id.edtMain_marca);
        edtMain_modelo= findViewById(R.id.edtMain_modelo);
        edtMain_ram= findViewById(R.id.edtMain_ram);
        edtMain_sistema = findViewById(R.id.edtMain_sistema);
        edtMain_rut = findViewById(R.id.edtMain_rut);
        edtMain_estado= findViewById(R.id.edtMain_estado);
        edtMain_requerimiento = findViewById(R.id.edtMain_requerimiento);


    }

    public void guardarDatos(View View){

        gestorDeBaseDeDatos gestor = new gestorDeBaseDeDatos(this,"computadores",null,1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = edtMain_id.getText().toString();
        String marca = edtMain_marca.getText().toString();
        String modelo = edtMain_modelo.getText().toString();
        String ram = edtMain_ram.getText().toString();
        String sistema = edtMain_sistema.getText().toString();
        String rut = edtMain_rut.getText().toString();
        String estado = edtMain_estado.getText().toString();
        String requerimiento = edtMain_requerimiento.getText().toString();

        if (!id.isEmpty() && !marca.isEmpty() && !modelo.isEmpty() && !ram.isEmpty() && !sistema.isEmpty() && !rut.isEmpty() && !estado.isEmpty() && !requerimiento.isEmpty()){

            ContentValues fila = new ContentValues();

            fila.put("id", id);
            fila.put("marca", marca);
            fila.put("modelo", modelo);
            fila.put("ram", ram);
            fila.put("sistema", sistema);
            fila.put("rut", rut);
            fila.put("estado", estado);
            fila.put("requerimiento", requerimiento);

            db.insert("equipos",null,fila);
            db.close();

            Toast.makeText(this, "equipo ingresado exitosamente", Toast.LENGTH_SHORT).show();

            edtMain_id.setText("");
            edtMain_marca.setText("");
            edtMain_modelo.setText("");
            edtMain_ram.setText("");
            edtMain_sistema.setText("");
            edtMain_rut.setText("");
            edtMain_estado.setText("");
            edtMain_requerimiento.setText("");

        }else {
            Toast.makeText(this, "por complete todos los campos", Toast.LENGTH_SHORT).show();
            db.close();
        }




    }
    public void goToActivity_recepcionista(View view){
        Intent activity1 = new Intent(this, recepcionista.class);
        startActivity(activity1);
    }



}