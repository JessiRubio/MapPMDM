package com.mappmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class LugarActivity extends AppCompatActivity {

    /**------------------------------- Pantalla lugar seleccionado ---------------------------------
     * Es la pantalla que se muestra despues de hacer click en la ubicación configurada previamente
     * y que muestra la información de dicho lugar.
     * En nuestro caso, la información se mostrara de forma random.**/

    /*Declaramos los objetos necesarios*/
    private ImageView icono;
    private TextView descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);

        //Inicializamos
        icono = findViewById(R.id.iconoLugar);
        descripcion = findViewById(R.id.desc_lugar);

        //Creamos un numero que se carga de forma random
        int lugarAleatorio = lugarRandom();
        //Cargamos la información segun el numero conseguido anteriormente
        cargarInformacion(lugarAleatorio);


    }

    /*Este metodo tras recibir un numero cargara la información segun el valor de este en los
    * objetos declarados e inicializados en la parte superior*/
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

    /* Este metodo devuele un numero entero entre 0 y 6 ambos incluidos de forma aleatoria*/
    private int lugarRandom(){
        int random;
        int nOpciones = 6;
        random = (int) Math.floor(Math.random() * nOpciones );
        return random;
    }
}
