package com.example.proyectopoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {

    EditText txtIngresoNombre, txtIngresoCorreo, txtIngresoConstrasenia;
    Button btnRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        txtIngresoNombre = findViewById(R.id.txtIngresoNombre);
        txtIngresoCorreo = findViewById(R.id.txtIngresoCorreo);
        txtIngresoConstrasenia = findViewById(R.id.txtIngresoConstrasenia);
        btnRegistro = findViewById(R.id.btnRegistro);


    }
    public void vistaPregunta(View activity_preguntas){

        Intent pregunta = new Intent(this, activity_preguntas.class);
        startActivity(pregunta);

    }

    public void Registro(){
        Usuario usuario = new Usuario(Registrar.this,txtIngresoNombre.getText().toString(),txtIngresoConstrasenia.getText().toString(),txtIngresoCorreo.getText().toString());
        long id = usuario.registroUsuario();

        if (id > 0){
            Toast.makeText(Registrar.this,"Usuario Registrado",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Registrar.this,"Error al Registrar Usuario",Toast.LENGTH_LONG).show();
        }

        txtIngresoNombre.setText("");
        txtIngresoCorreo.setText("");
        txtIngresoConstrasenia.setText("");


    }


}