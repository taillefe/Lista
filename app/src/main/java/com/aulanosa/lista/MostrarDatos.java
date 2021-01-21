package com.aulanosa.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MostrarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        // recibo los datos a través del bundle

        final EditText nombre = findViewById(R.id.edTxtNombre);
        final EditText apellidos = findViewById(R.id.edTxtApellidos);
        final EditText telefono = findViewById(R.id.edTxtTelefono);
        final EditText email = findViewById(R.id.edTxtEmail);
        final EditText direccion = findViewById(R.id.edTxtDireccion);
        final EditText observaciones = findViewById(R.id.edTxtObservaciones);





    }
}