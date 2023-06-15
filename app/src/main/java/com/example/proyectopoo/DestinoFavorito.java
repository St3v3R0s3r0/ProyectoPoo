package com.example.proyectopoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DestinoFavorito extends Conexion{
    private Conexion conexion;
    private SQLiteDatabase db;

    public DestinoFavorito(@Nullable Context context) {
        super(context);
        conexion = new Conexion(context);
        db = conexion.getWritableDatabase();
    }

}
