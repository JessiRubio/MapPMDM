package com.mappmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        btn_ver_localizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cargarPunto = new Intent(FormularioActivity.this,MapActivity.class);
                cargarPunto.putExtra("latitud", Double.parseDouble(String.valueOf(et_latitud.getText())));
                cargarPunto.putExtra("longitud",Double.parseDouble(String.valueOf(et_longitud.getText())));
                startActivity(cargarPunto);
            }
        });
    }
}
