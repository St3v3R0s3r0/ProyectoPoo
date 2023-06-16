package com.example.proyectopoo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.concurrent.ExecutionException;

public class Destino{
    private Conexion conexion;
    private SQLiteDatabase db;

    private String codigo;
    private String nombre;
    private String descripcion;
    private String link;
    private String descripcionCorta;
    private String horario;
    private String precios;

    public Destino(String codigo, String nombre, String descripcion, String link, String descripcionCorta, String horario, String precios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
        this.descripcionCorta = descripcionCorta;
        this.horario = horario;
        this.precios = precios;
    }

    static Destino getDestino(String codigo){
        Destino destino = null;
        try {
            Conexion conexion = new Conexion(null);
            SQLiteDatabase db = conexion.getWritableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM destino WHERE des_codigo = " + codigo, null);

            if (cursor.moveToFirst()) {
                destino = new Destino(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                );
            }
        } catch (Exception e){

        }
        return destino;
    }
}