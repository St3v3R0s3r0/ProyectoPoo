package com.example.proyectopoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "destinos.db";
    private static final String TABLE_ = "destinos.db";

    public Conexion(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

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

        db.execSQL("CREATE  INDEX DESTINO_ES_PREFERIBLE_USUARIO_ ON DESTINO_FAVORITO\n" +
                "(\n" +
                "   DES_CODIGO ASC\n" +
                ");");
        db.execSQL("CREATE  INDEX USUARIO_PREFIERE_DESTINO_FK ON DESTINO_FAVORITO\n" +
                "(\n" +
                "   USU_NOMBRE ASC\n" +
                ");");

        db.execSQL("INSERT INTO DESTINO VALUES('DST-001','Katari','Bar tipo pub, con un ambiente acogedor y moderno,elbar Katari se destaca por su enfoque en la música en vivo y la diversidad cultural.', 'https://goo.gl/maps/pMjo474gKfAfWFRh6', 'Katari - Pub', '5:00pm - 0:00am', 'Medio - Alto');");
        db.execSQL("INSERT INTO DESTINO VALUES('DST-002', 'Casino','Discoteca de alto prestigio y con las mejores fiestas dentro de la ciudad','https://goo.gl/maps/9LQpfDxKZbKWJkX8A', 'Casino - Discoteca', '7:00pm - 3:00am', 'Alto');");
        db.execSQL("INSERT INTO DESTINO VALUES('DST-003', 'Parque de Guapulo','Uno de los parques mas lindos de la ciudad, el cual ofrece grandes vistas panoramicas','https://goo.gl/maps/T6JdABaKNaWonxuv8', 'Parque - Guapulo', '6:00am - 6:00pm', 'Gratuito');");
        db.execSQL("INSERT INTO DESTINO VALUES('DST-004', 'Parque Itchimbia','Es una de los parque que tiene Quito donde se podrá hacer ejercicio con unas vistas del centro histórico de Quito','https://goo.gl/maps/zGf7NnFuLeVjp5zD6', 'Parque - Itchimbia', '6:00am - 6:00pm', 'Gratuito');");
        db.execSQL("INSERT INTO DESTINO VALUES('DST-005', 'Museo Iglesia San Francisco', 'Uno de los sitios mas emblematicos del centro historico, el cual ofrece una experiencia unica al recorrer los pasillos del convento, en especial al momento de subir a las torres y tener una buena vista panoramica del centro historico','https://goo.gl/maps/dYKz2dxANW1SNatK6', 'Museo - San Francisco', '9:00am - 5:00pm', 'Gratuito');");
        db.execSQL("INSERT INTO DESTINO VALUES('DST-006', 'Museo de la Ciudad', 'Museo en donde se rescata toda la historia de la ciudad de Quito','https://goo.gl/maps/xiFxzzmjwPR2j66x6', 'Museo - Ciudad', '10:00am - 5:30pm', 'Gratuito');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
