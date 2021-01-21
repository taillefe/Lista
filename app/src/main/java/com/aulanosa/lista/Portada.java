package com.aulanosa.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Portada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //OCULTAMOS TÍTULO
        getSupportActionBar().hide();
        setContentView(R.layout.activity_portada);

        Button btnLista = (Button) findViewById(R.id.btnLista);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cuando pulsa en el mensaje llama a la pantalla de preferencias
                Intent cambioVentana = new Intent(Portada.this, MainActivity.class);
                startActivity(cambioVentana);
            }
        });


    }
}