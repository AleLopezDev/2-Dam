package com.example.proyectoandroid;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class VistaEmpresa extends android.app.Activity {

    Spinner sp;
    String[] panes = {"Pepe","jasf"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_empresas);




    }

    public void rellenarSpinner(Spinner sp){
       ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.nombrePanes, android.R.layout.simple_spinner_dropdown_item);
       sp.setAdapter(adapter);
    }
}
