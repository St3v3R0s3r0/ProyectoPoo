package com.example.proyectopoo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public long registroUsuario(){
        long id=-1;
        ContentValues values = new ContentValues();

        values.put("usu_nombre", this.nombre);
        values.put("usu_contrasena", this.contrasena);
        values.put("usu_correo", this.correo);

        try {
            id = db.insert("usuario", null, values);
        } catch (Exception e){

        }
        return id;
    }

    public boolean inicioSesion(){
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM usuario WHERE usu_nombre = " + this.nombre + " AND usu_contrasena = " + this.contrasena, null);
        } catch (Exception e){

        }
        boolean usuario = cursor.moveToFirst();

        return usuario;
    }
}