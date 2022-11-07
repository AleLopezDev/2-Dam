package com.example.listviewprueba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Person> listaPersonas = new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<Person> listaPersonas) {
        mContext = context;
        this.listaPersonas = listaPersonas;
    }

    @Override
    public int getCount() {
        return listaPersonas.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPersonas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    // Este método se va a repetir por tantas personas haya en el array
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.listviewlayout, viewGroup, false);
        }

        Person tempPerson = (Person) getItem(i);

        TextView tvEdad = (TextView) view.findViewById(R.id.Edad);
        TextView tvNombre = (TextView) view.findViewById(R.id.Nombre);

        tvNombre.setText(tempPerson.getNombre());
        tvEdad.setText(String.valueOf(tempPerson.getEdad()));


        return view;
    }
}
