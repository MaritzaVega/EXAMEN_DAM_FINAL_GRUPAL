package com.dam.dam_examen_final_grupal;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarcadorActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double latitud;
    private Double longitud;
    private String dato1, dato2, dato3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcador);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        //Obtenemos los datos
        dato1 = getIntent().getStringExtra("dato1");
        dato2 = getIntent().getStringExtra("dato2");
        dato3 = getIntent().getStringExtra("dato3");

        latitud = Double.parseDouble(dato1);
        longitud = Double.parseDouble(dato2);

        Toast.makeText(this,dato3 , Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        final LatLng carla = new LatLng(latitud,longitud);

        mMap.addMarker(new MarkerOptions().position(carla).title(dato3));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(carla));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}