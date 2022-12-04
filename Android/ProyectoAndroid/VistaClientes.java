package com.example.proyectoandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class VistaClientes  extends android.app.Activity {

    ArrayList<Pan>arrayPanes = new ArrayList<>();
    ListView listView;
    Spinner spNombre, spPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vista_clientes);
        listView = findViewById(R.id.listView);
        spNombre = (Spinner) findViewById(R.id.spNombre);

        crearPanes();
        rellenarListView();
        rellenarSpinner(spNombre);
    }

    public void crearPanes(){

        String[] nombrePanes = getResources().getStringArray(R.array.nombrePanes);
        String[] precioPanes = getResources().getStringArray(R.array.precioPanes);

        for(int i=0;i<nombrePanes.length;i++){
            Pan p = new Pan(nombrePanes[i],Double.parseDouble(precioPanes[i]),(int) (Math.random()*20 + 0));
            arrayPanes.add(p);
        }
    }

    public void rellenarListView(){
        CustomAdapter miCustomAdapter = new CustomAdapter(getApplicationContext(),arrayPanes);
        listView.setAdapter(miCustomAdapter);
    }

    public void rellenarSpinner(Spinner sp){
        sp.setAdapter(new ArrayAdapter<Pan> (this, android.R.layout.simple_spinner_dropdown_item,arrayPanes));
    }
}
