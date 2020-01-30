package com.mappmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class InicioActivity extends AppCompatActivity {

    /**---------------------------- Activity de la pantalla inicial -------------------------------
     * Esta pantalla simplemente es estetica, no tiene funcionalidad alguna. Por ello, solo consta
     * de un delay de 3 segundos antes de pasar a la pantalla principal, el mapa.**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Delay de 3 segundos antes de hacer el cambio de pantalla
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos

                Intent verSitio = new Intent(InicioActivity.this,FormularioActivity.class);
                startActivity(verSitio);
            }
        }, 3000);
    }
}
