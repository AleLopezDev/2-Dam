package com.example.proyectoandroid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<Pan> arrayPanes = new ArrayList<>();
    Context contexto;

    public CustomAdapter(Context mainActivity, ArrayList<Pan> listaPanes) {
        this.contexto = mainActivity;
        this.arrayPanes = listaPanes;
    }


    @Override
    public int getCount() {
        return arrayPanes.size();
    }

    @Override
    public Object getItem(int position) {

        return arrayPanes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(contexto).inflate(R.layout.listview_item, parent, false);
        }

        Pan tempPan = (Pan) getItem(position);

        TextView tvNombre = (TextView) convertView.findViewById(R.id.nombrePanListView);
        TextView tvPrecio = (TextView) convertView.findViewById(R.id.precioPanListView);
        TextView tvCantidad = (TextView) convertView.findViewById(R.id.cantidadPanListView);

        tvNombre.setText("Nombre: " + tempPan.getNombre());
        tvPrecio.setText("Precio: " + String.valueOf(tempPan.getPrecio()));
        tvCantidad.setText("Unidades: " +String.valueOf(tempPan.getCantidadDisponible()));

        return convertView;
    }
}
