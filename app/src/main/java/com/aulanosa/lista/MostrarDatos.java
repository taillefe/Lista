package com.aulanosa.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MostrarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        // recibo los datos a través del bundle


       // final ImageView imagen = findViewById(R.id.imagen);
        final EditText nombre = findViewById(R.id.edTxtNombre);
        final EditText apellidos = findViewById(R.id.edTxtApellidos);
        final EditText telefono = findViewById(R.id.edTxtTelefono);
        final EditText email = findViewById(R.id.edTxtEmail);
        final EditText direccion = findViewById(R.id.edTxtDireccion);
        final EditText observaciones = findViewById(R.id.edTxtObservaciones);

        Bundle bundle=getIntent().getExtras();
        String imagenActual = bundle.getString("IMAGEN");
        nombre.setText(bundle.getString("NOMBRE"));
        apellidos.setText(bundle.getString("APELLIDOS"));
        telefono.setText(bundle.getString("TELEFONO"));
        email.setText(bundle.getString("EMAIL"));
        direccion.setText(bundle.getString("DIRECCION"));
        observaciones.setText(bundle.getString("OBSERVACIONES"));

        Log.i("imagen",imagenActual);

        ImageView imageView = (ImageView)  this.findViewById(R.id.imagen);
       //   imageView.setImageURI(Uri.parse(imagenActual));
        //  imageView.setImageBitmap(StringToBitMap(currentImagen));

        File imagenArchivo= new  File(imagenActual);
        //  imageView.setImageURI(Uri.fromFile(imagenArchivo));
        Log.i("ruta",imagenArchivo.getName());
        Toast.makeText(this,
                "ruta: "+ imagenArchivo.getName(), Toast.LENGTH_LONG).show();

     //   Bitmap myBitmap = BitmapFactory.decodeFile(imagenArchivo.getName());
      //  imageView.setImageBitmap(myBitmap);





    }
}