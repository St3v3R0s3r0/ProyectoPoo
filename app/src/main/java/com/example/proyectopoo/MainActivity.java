package com.example.proyectopoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo para ingresar al Login 'Ingresar'
    public void Ingresar(View Login){
        Intent ingresar = new Intent(this, Login.class);
        startActivity(ingresar);
    }

    //Metodo para ingresar al apartado 'Registrar'
    public void Registrar(View Registrar){
        Intent registrar = new Intent(this, Registrar.class);
        startActivity(registrar);
    }



}