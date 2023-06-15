package com.example.proyectopoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "destinos.db";
    private static final String TABLE_ = "destinos.db";
    public Conexion(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("DROP TABLE DESTINO;");
        db.execSQL("DROP INDEX USUARIO_PREFIERE_DESTINO_FK;");
        db.execSQL("DROP INDEX DESTINO_ES_PREFERIBLE_USUARIO_;");
        db.execSQL("DROP TABLE DESTINO_FAVORITO;");
        db.execSQL("DROP TABLE USUARIO;");
        db.execSQL("CREATE TABLE DESTINO\n" +
                "(\n" +
                "   DES_CODIGO           VARCHAR(20),\n" +
                "   DES_NOMBRE           VARCHAR(40),\n" +
                "   DES_DESCRIPCION      VARCHAR(1000),\n" +
                "   DES_LINKGMAP         VARCHAR(1024),\n" +
                "   DES_DESCCORTA        VARCHAR(256),\n" +
                "   DES_HORARIOS         VARCHAR(256),\n" +
                "   DES_PRECIOS          VARCHAR(256),\n" +
                "   PRIMARY KEY (DES_CODIGO)\n" +
                ");");
        db.execSQL("CREATE TABLE USUARIO\n" +
                "(\n" +
                "   USU_NOMBRE           VARCHAR(20),\n" +
                "   USU_CONTRASENA       VARCHAR(30),\n" +
                "   USU_CORREO       VARCHAR(40),\n" +
                "   PRIMARY KEY (USU_NOMBRE)\n" +
                ");");
        db.execSQL("CREATE TABLE DESTINO_FAVORITO\n" +
                "(\n" +
                "   DES_CODIGO           VARCHAR(20),\n" +
                "   USU_NOMBRE           VARCHAR(20),\n" +
                "   PRIMARY KEY (DES_CODIGO, USU_NOMBRE),\n" +
                "   foreign key (DES_CODIGO)\n" +
                "         references DESTINO (DES_CODIGO),\n" +
                "   foreign key (USU_NOMBRE)\n" +
                "         references USUARIO (USU_NOMBRE)\n" +
                ");");
        db.execSQL("CREATE  INDEX DESTINO_ES_PREFERIBLE_USUARIO_ ON DESTINO_FAVORITO\n" +
                "(\n" +
                "   DES_CODIGO ASC\n" +
                ");");
        db.execSQL("CREATE  INDEX USUARIO_PREFIERE_DESTINO_FK ON DESTINO_FAVORITO\n" +
                "(\n" +
                "   USU_NOMBRE ASC\n" +
                ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
