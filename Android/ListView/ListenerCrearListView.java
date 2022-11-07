package com.example.listviewprueba;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListenerCrearListView implements View.OnClickListener {

    private Context mContext;
    private ArrayList<Person> listaPersonas;
    ListView listView ;

    public ListenerCrearListView(MainActivity mainActivity, ArrayList<Person> listaPersonas, ListView listView) {
        this.mContext = mainActivity;
        this.listaPersonas = listaPersonas;
        this.listView = listView;
    }

    @Override
    public void onClick(View view) {
        rellenarListView();
    }

    public void rellenarListView() {
        // Mi clase customAdapter
        CustomAdapter myCustomAdapter = new CustomAdapter(mContext, listaPersonas);
        listView.setAdapter(myCustomAdapter);
    }
}