package com.example.proyectopoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText txtIngresoNombre, txtIngresoConstrasenia;
    Button btnRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtIngresoNombre = findViewById(R.id.txtIngresoNombre);
        txtIngresoConstrasenia = findViewById(R.id.txtIngresoConstrasenia);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario(Login.this,txtIngresoNombre.getText().toString(),txtIngresoConstrasenia.getText().toString(),"");
                boolean id = usuario.inicioSesion();

                if (id){
                    Toast.makeText(Login.this,"Usuario Registrado",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Login.this,"Error al Registrar Usuario",Toast.LENGTH_LONG).show();
                }

                txtIngresoNombre.setText("");
                txtIngresoConstrasenia.setText("");
            }
        });
    }

    public void vistaPregunta(View activity_preguntas){
        Intent pregunta = new Intent(this, activity_preguntas.class);
        startActivity(pregunta);
    }

}