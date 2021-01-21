package com.aulanosa.lista;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> names;
    private ArrayList<String> imagenes;

    public MyAdapter(Context context, int layout, ArrayList<String> names,ArrayList<String> imagenes) {
        this.context = context;
        this.layout = layout;
        this.names = names;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
// Copiamos la vista
        View v = convertView;
//Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_item, null);
// Valor actual según la posición
        String currentName = names.get(position);
// Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(currentName);

       //lo mismo para la imagen
        // Valor actual según la posición
        String currentImagen = imagenes.get(position);
// Referenciamos el elemento a modificar y lo rellenamos
        @SuppressLint("WrongViewCast") ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
      //  imageView.setImageURI(Uri.parse(currentImagen));
      //  imageView.setImageBitmap(StringToBitMap(currentImagen));

        File imagenArchivo= new  File(currentImagen);
      //  imageView.setImageURI(Uri.fromFile(imagenArchivo));



        Log.i("ruta",imagenArchivo.getAbsolutePath());




            Bitmap myBitmap = BitmapFactory.decodeFile(imagenArchivo.getAbsolutePath());
            imageView.setImageBitmap(myBitmap);


//Devolvemos la vista inflada
        return v;
    }


    public Bitmap StringToBitMap(String image){
        try{
            byte [] encodeByte= Base64.decode(image,Base64.DEFAULT);

            InputStream inputStream  = new ByteArrayInputStream(encodeByte);
            Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }
}
