package com.example.clinica_app;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class gestorDeBaseDeDatos extends SQLiteOpenHelper{

    String tabla_equipos= " CREATE TABLE equipos(id int primary key, marca text, modelo text, ram text, sistema text, rut_propietario text, estado text, requerimiento text, comentario text)";


    public gestorDeBaseDeDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_equipos);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
