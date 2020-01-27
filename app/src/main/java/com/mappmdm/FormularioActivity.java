package com.mappmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

/**------------------------------------ Activity del formulario -----------------------------------
 * En este activity vamos a configurar el formulario para que más tarde el mapa nos lleve al lugar
 * indicado por el usuario**/

public class FormularioActivity extends AppCompatActivity {

    //Declaración de objetos a utilizar

    private EditText et_latitud;
    private EditText et_longitud;
    private Button btn_ver_localizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //Inicialización del formulario
        et_latitud = findViewById(R.id.et_latitud);
        et_longitud = findViewById(R.id.et_longitud);
        btn_ver_localizacion = findViewById(R.id.btn_ver_localizacion);

        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();


        btn_ver_localizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cargarPunto = new Intent(FormularioActivity.this,MapActivity.class);

                if(et_latitud.getText()!=null && et_longitud.getText()!=null){
                    editor.putFloat("latitud",Float.parseFloat(String.valueOf(et_latitud.getText())));
                    editor.putFloat("longitud", Float.parseFloat(String.valueOf(et_longitud.getText())));
                    editor.commit();
                    startActivity(cargarPunto);
                }


            }
        });
    }
}
