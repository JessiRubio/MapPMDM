package com.mappmdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.Objects;

/**---------------------------------------Pantalla Mapa--------------------------------------------
 * En esta pantalla configuramos las items del mapa y el botón que aparece en el layout activity-map.
 * ---Para ello, elegiremos el mapa de mapbox y configuraremos el botón para que haga Intent a un---
 * ----------------formulario que nos va a permitirnos ir al formulario---------------------------**/

public class MapActivity extends AppCompatActivity {

    private MapView mapView;
    private Button btn_lugar_ideal;
    private MediaPlayer music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** generamos e inicializamos los objetos sobre los que vamos a trabajar **/
        Mapbox.getInstance(this, "pk.eyJ1IjoiZXF1aXBhc28xIiwiYSI6ImNrMnhhMjg0YzA5cmEzanBtNndxejQ0ZWgifQ.QLRB9ZbTIevBBxwNYvjelw");
        setContentView(R.layout.activity_map);
        mapView = findViewById(R.id.mapView);
        btn_lugar_ideal = findViewById(R.id.btn_formulario);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback(){
            @Override
            public void onMapReady(@NonNull final MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                        Intent datoEntrada = getIntent();
                        String nombreLugar = datoEntrada.getStringExtra("nombreLugar");
                        Double latitud = datoEntrada.getDoubleExtra("latitud",43);
                        Double longitud = datoEntrada.getDoubleExtra("longitud",-8);

                       /*SharedPreferences preferencias = getPreferences(MODE_PRIVATE);
                        Double latitud = preferencias.getFloat("latitud",5);
                        Double longitud = preferencias.getFloat("latitud",5);*/

                        CameraPosition locationZoom = new CameraPosition
                                .Builder()
                                .target(new LatLng(latitud,longitud))
                                .zoom(6)
                                .build();

                        MarkerOptions location = new MarkerOptions()
                                .position(new LatLng(latitud, longitud))
                                .title(nombreLugar);

                        mapboxMap.addMarker(location);
                        mapboxMap.setCameraPosition(locationZoom);

                        mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(@NonNull Marker marker) {
                                music = MediaPlayer.create(MapActivity.this, R.raw.misc021);
                                music.start();

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        // acciones que se ejecutan tras los milisegundos
                                        music.stop();
                                        Intent verSitio = new Intent(MapActivity.this,LugarActivity.class);
                                        startActivity(verSitio);
                                    }
                                }, 2000);
                                return false;
                            }
                        });

                    }
                });
            }
        });



        /**------Configuramos la funcionalidad del botón para que nos lleve al formulario--------**/
        btn_lugar_ideal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formulario = new Intent(MapActivity.this,FormularioActivity.class);
                startActivity(formulario);
            }
        });
    }

    /**---------------------- Funciones del ciclo de vida del activity --------------------------**/
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try{
            music.stop();
        }
        catch (Exception e){

        }

        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
