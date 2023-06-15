package com.example.proyectopoo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Usuario extends Conexion{
    private Conexion conexion;
    private SQLiteDatabase db;
    private String nombre;
    private String contrasena;
    private String correo;

    public String getNombre() {
        return nombre;
    }

    public Usuario(@Nullable Context context, String nombre, String contrasena, String correo) {
        super(context);
        conexion = new Conexion(context);
        db = conexion.getWritableDatabase();
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    static Usuario getUsuario(String nombre, String contrasena){
        Usuario usuario = null;

        ContentValues values =new ContentValues();


        return usuario;
    }

    public void registroUsuario(){

    }

    static public Usuario inicioSesion(String nombre, String contrasena){
        Usuario usuario = null;

        return usuario;
    }
}
