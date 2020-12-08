package com.example.clinica_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tecnico extends AppCompatActivity {

    EditText edtDetalle_id;
    TextView text_marca,text_modelo,text_ram,text_sistema,text_rut,text_estado,text_requerimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnico);

        edtDetalle_id = findViewById(R.id.edtDetalle_id);
        text_marca = findViewById(R.id.text_marca);
        text_modelo = findViewById(R.id.text_modelo);
        text_ram = findViewById(R.id.text_ram);
        text_sistema = findViewById(R.id.text_sistema);
        text_rut = findViewById(R.id.text_rut);
        text_estado = findViewById(R.id.text_estado);
        text_requerimiento = findViewById(R.id.text_requerimiento);
    }

    public void consultarDatos(View View){

        gestorDeBaseDeDatos gestor = new gestorDeBaseDeDatos(this,"computadores",null,1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = edtDetalle_id.getText().toString();

        Cursor datos = db.rawQuery("select marca, modelo, ram, sistema, rut_propietario, estado, requerimiento from equipos where id ="+id,null);
        if (datos.moveToFirst()){
            text_marca.setText(datos.getString(0).toString());
            text_modelo.setText(datos.getString(1).toString());
            text_ram.setText(datos.getString(2).toString());
            text_sistema.setText(datos.getString(3).toString());
            text_rut.setText(datos.getString(4).toString());
            text_estado.setText(datos.getString(5).toString());
            text_requerimiento.setText(datos.getString(6).toString());
            db.close();

        }else{
            Toast.makeText(this, "no existes registros asociasdos a la ID", Toast.LENGTH_SHORT).show();
        }
        db.close();



    }


}