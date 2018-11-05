package com.example.blacknesswolf.crud.Entidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.blacknesswolf.crud.Utilidades.Utilidades;

public class ConexionSQLiteH extends SQLiteOpenHelper {
//Constructor
    public ConexionSQLiteH(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    //Genera Tablas y recibe la base de datos creada
    public void onCreate(SQLiteDatabase BD) {
BD.execSQL(Utilidades.CREAR_TABLA_PERSONAS);
    }

    @Override
    //Verifica si hay una version antigua de nuestra BD "i=Version antigua,iI=VErsion nueva"
    public void onUpgrade(SQLiteDatabase BD, int i, int i1) {
       //Si ya existe la tabla que la borre
        BD.execSQL("DROP TABLE IF EXISTS personas");
        onCreate(BD);
    }
}
