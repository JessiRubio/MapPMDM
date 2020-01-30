package com.mappmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

/**------------------------------------ Activity del formulario -----------------------------------
 * En este activity vamos a configurar el formulario para que más tarde el mapa nos lleve al lugar
 * indicado por el usuario**/

public class FormularioActivity extends AppCompatActivity {

    //Declaración de objetos a utilizar

    private EditText et_nombre_lugar;
    private EditText et_latitud;
    private EditText et_longitud;
    private Button btn_ver_localizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //Inicialización del formulario
        et_nombre_lugar = findViewById(R.id.et_nombre_lugar);
        et_latitud = findViewById(R.id.et_latitud);
        et_longitud = findViewById(R.id.et_longitud);
        btn_ver_localizacion = findViewById(R.id.btn_ver_localizacion);

        /*SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();*/

        /*Configuramos el on click del boton ver localización para que le pase los
        * datos necesarios al mapa y así se pueda ver la localización seleccionada*/
        btn_ver_localizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Generamos un Intent para el cambio de pantalla*/
                Intent cargarPunto = new Intent(FormularioActivity.this,MapActivity.class);

                /*Recogemos los datos y se los pasamos al intent para el envio, para ello, primero
                * comprobamos que los campos no esten vacios y en caso de estarlo pedimos que se
                * completen.*/
                if(!et_nombre_lugar.getText().toString().equals("") &&
                        !et_latitud.getText().toString().equals("") &&
                        !et_longitud.getText().toString().equals("")){
                    cargarPunto.putExtra("nombreLugar",et_nombre_lugar.getText().toString());
                    cargarPunto.putExtra("latitud",Double.parseDouble(String.valueOf(et_latitud.getText())));
                    cargarPunto.putExtra("longitud", Double.parseDouble(String.valueOf(et_longitud.getText())));
                    /*Realizamos el cambio de pantalla*/
                    startActivity(cargarPunto);
                }else{
                    Toast toast = Toast.makeText(getBaseContext(),"Por favor introduzca todos los datos",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
