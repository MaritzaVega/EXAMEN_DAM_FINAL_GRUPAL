package com.dam.dam_examen_final_grupal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//repositorio y proyecto url : https://github.com/MaritzaVega/EXAMEN_DAM_FINAL_GRUPAL.git

    private EditText Email, Contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.txtemail);
        Contrasenia = (EditText) findViewById(R.id.txtpassword);
    }

    public void Enviar(View view) {


        if (Email.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo Email vacio", Toast.LENGTH_LONG).show();
        } else {
            if (Contrasenia.getText().toString().isEmpty()) {
                Toast.makeText(this, "Campo contraseña Vacio", Toast.LENGTH_LONG).show();
            } else {
                if (Contrasenia.getText().toString().length() < 4) {
                    Toast.makeText(this, "Tiene que contener al menos 4 digitos", Toast.LENGTH_LONG).show();
                } else {
                    Intent login = new Intent(this, InicioSesionActivity.class);

                    //enviar datos email
                    login.putExtra("dato1", Email.getText().toString());
                    //enviar datos Contrasenia
                    login.putExtra("dato2", Contrasenia.getText().toString());

                    startActivity(login);
                }
            }
        }
    }
}