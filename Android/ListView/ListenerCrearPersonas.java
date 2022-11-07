package com.example.listviewprueba;

import android.view.View;

import java.util.ArrayList;

public class ListenerCrearPersonas implements View.OnClickListener {

    private ArrayList<Person>listaPersonas;

    public ListenerCrearPersonas(ArrayList<Person> listaPersonas){
        this.listaPersonas = listaPersonas;

    }
    @Override
    public void onClick(View view) {
        crearPersonas();
    }

    // Creamos 25 personas y lo añadimos al arraylist de personas
    public void crearPersonas(){

        Person p = new Person();
        String nombre = "Joe";
        int edad = 20;

        for(int i=0;i<25;i++){
            p = new Person(nombre + i, edad);
            listaPersonas.add(p);
        }
    }
}
