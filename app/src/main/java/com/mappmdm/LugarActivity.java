package com.mappmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class LugarActivity extends AppCompatActivity {

    private ImageView icono;
    private TextView descripcion;

    private static ArrayList<String> listaImagenes;
    private static ArrayList<String> listaTextos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);
        icono = findViewById(R.id.iconoLugar);
        descripcion = findViewById(R.id.desc_lugar);

        int lugarAleatorio = lugarRandom();
        cargarInformacion(lugarAleatorio);


    }

    private void cargarInformacion(int lugar) {
        switch (lugar){
            case 0:
                icono.setImageDrawable(getDrawable(R.drawable.foto1));
                descripcion.setText(getString(R.string.texto1));
                break;
            case 1:
                icono.setImageDrawable(getDrawable(R.drawable.foto2));
                descripcion.setText(getString(R.string.texto2));
                break;
            case 2:
                icono.setImageDrawable(getDrawable(R.drawable.foto3));
                descripcion.setText(getString(R.string.texto3));
                break;
            case 3:
                icono.setImageDrawable(getDrawable(R.drawable.foto4));
                descripcion.setText(getString(R.string.texto4));
                break;
            case 4:
                icono.setImageDrawable(getDrawable(R.drawable.foto5));
                descripcion.setText(getString(R.string.texto5));
                break;
            case 5:
                icono.setImageDrawable(getDrawable(R.drawable.foto6));
                descripcion.setText(getString(R.string.texto6));
                break;
        }
    }

    private int lugarRandom(){
        int random;
        int nOpciones = 6;
        random = (int) Math.floor(Math.random() * nOpciones );
        return random;
    }
}
