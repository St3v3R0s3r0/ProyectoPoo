package com.example.proyectopoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_preguntas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
    }

    public void vistaFiesta(View activity_Fiestas){
        Intent fiesta = new Intent(this, activity_Fiestas .class);
        startActivity(fiesta);
    }

    public void vistaNaturaleza(View activity_naturaleza){
        Intent naturaleza = new Intent(this, activity_naturaleza.class);
        startActivity(naturaleza);
    }

    public void vistaHistoria(View activity_historia){
        Intent historia = new Intent(this, activity_historia.class);
        startActivity(historia);
    }


}