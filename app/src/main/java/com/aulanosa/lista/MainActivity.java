package com.aulanosa.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private ArrayList<String> names;
    private ArrayList<String> imagenes;
  //  private String[] listanombres = {"Pedro","Ramón","Jose","Luisa","Antonio","Hugo"};

    private ArrayList<Contactos> listaContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //OCULTAMOS TÍTULO
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.eleuve);

        listaContactos = new ArrayList<Contactos>();

        // imagenes como cadena de bits
        // Blob blob = rs.getBlob("image");
        //        foto = ImageIO.read(blob.getBinaryStream());


        Contactos contacto1 = new Contactos("C:\\Users\\PC33\\Desktop\\emoji.png","Pedro", "Perez", "444555666","pedro@gmail.com",
                "libertad, 3", "perfecto");
        Contactos contacto2 = new Contactos("@raw/emoji.png","Ramón", "Rodriguez", "333555666","ramon@gmail.com",
                "camelias, 1", "imperfecto");
        Contactos contacto3 = new Contactos("@raw/emoji.png","Jose", "Blanco", "444555444","jose@gmail.com",
                "rosas, 23", "tranquilo");
        Contactos contacto4 = new Contactos("@raw/emoji.png","Luisa", "Gutierrez", "666555666","luisa@gmail.com",
                "colon, 3", "locuaz");
        Contactos contacto5 = new Contactos("@raw/emoji.png","Antonio", "Lopez", "777555666","antonio@gmail.com",
                "real, 9", "grandioso");
        Contactos contacto6 = new Contactos("@raw/emoji.png","Hugo", "García", "888555666","hugo@gmail.com",
                "lugar, 6", "fenomenal");

        listaContactos.add(contacto1);
        listaContactos.add(contacto2);
        listaContactos.add(contacto3);
        listaContactos.add(contacto4);
        listaContactos.add(contacto5);
        listaContactos.add(contacto6);

        imagenes = new ArrayList<String>();

        imagenes.add(listaContactos.get(0).getImagen());
        imagenes.add(listaContactos.get(1).getImagen());
        imagenes.add(listaContactos.get(2).getImagen());
        imagenes.add(listaContactos.get(3).getImagen());
        imagenes.add(listaContactos.get(4).getImagen());
        imagenes.add(listaContactos.get(5).getImagen());


        names = new ArrayList<String>();

        names.add(listaContactos.get(0).getNombre());
        names.add(listaContactos.get(1).getNombre());
        names.add(listaContactos.get(2).getNombre());
        names.add(listaContactos.get(3).getNombre());
        names.add(listaContactos.get(4).getNombre());
        names.add(listaContactos.get(5).getNombre());


        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,names);

        lista.setAdapter(adapter);

        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, names, imagenes);

        lista.setAdapter(myAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

               Intent cambioVentana = new Intent(MainActivity.this, MostrarDatos.class);

               Bundle bundle =new Bundle();
                bundle.putString("IMAGEN", listaContactos.get(position).getImagen().toString());
               bundle.putString("NOMBRE", listaContactos.get(position).getNombre().toString());
               bundle.putString("APELLIDOS", listaContactos.get(position).getApellidos().toString());
               bundle.putString("TELEFONO", listaContactos.get(position).getTelefono().toString());
               bundle.putString("EMAIL", listaContactos.get(position).getEmail().toString());
               bundle.putString("DIRECCION", listaContactos.get(position).getDireccion().toString());
               bundle.putString("OBSERVACIONES", listaContactos.get(position).getObservaciones().toString());
               cambioVentana.putExtras(bundle);

               startActivity(cambioVentana);

                Toast.makeText(MainActivity.this,
                        "Has pulsado: "+ imagenes.get(position), Toast.LENGTH_LONG).show();
            }
        });

        Button btnAjustes = (Button) findViewById(R.id.btnAjustes);
        btnAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cuando pulsa en el boton llama a la pantalla de ajustes
                Intent cambioVentana = new Intent(Settings.ACTION_SETTINGS);
                startActivity(cambioVentana);
            }
        });

    /*
        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(names);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (MainActivity.this, android.R.layout.simple_list_item_1, names);

                lista.setAdapter(adapter);
            }
        });
    */
    }
}