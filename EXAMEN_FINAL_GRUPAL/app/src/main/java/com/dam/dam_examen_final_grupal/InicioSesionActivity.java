package com.dam.dam_examen_final_grupal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InicioSesionActivity extends AppCompatActivity {

    private EditText latitud, longitud, marcador;
    //hola
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        latitud = (EditText) findViewById(R.id.editTextLatitud);
        longitud = (EditText) findViewById(R.id.editTextLongitud);
        marcador = (EditText) findViewById(R.id.editTextMarcador);
    }

    public void EnviaDatos (View view) {

        if (latitud.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo latitud vacio", Toast.LENGTH_LONG).show();
        } else {
            if (longitud.getText().toString().isEmpty()) {
                Toast.makeText(this, "Campo longitud Vacio", Toast.LENGTH_LONG).show();
            } else {
                if (marcador.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Campo marcador Vacio", Toast.LENGTH_LONG).show();
                } else {
                    Intent marcador1 = new Intent(this, MarcadorActivity.class);

                    //enviar datos latitud
                    marcador1.putExtra("dato1", latitud.getText().toString());
                    //enviar datos longitus
                    marcador1.putExtra("dato2", longitud.getText().toString());
                    //enviar datos marcador
                    marcador1.putExtra("dato3", marcador.getText().toString());

                    startActivity(marcador1);
                }
            }
        }
    }
}