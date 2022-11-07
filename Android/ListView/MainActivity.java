package com.example.listviewprueba;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.listviewprueba.databinding.ActivityMainBinding;

import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button createPeople;
    Button populateListViewButton;

    ListView listView;
    ArrayList<Person>listaPersonas = new ArrayList<>();

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listView = findViewById(R.id.listView);

        createPeople = (Button) findViewById(R.id.botonPersona);
        populateListViewButton = (Button) findViewById(R.id.botonListView);


        createPeople.setOnClickListener(new ListenerCrearPersonas(listaPersonas));

        populateListViewButton.setOnClickListener(new ListenerCrearListView(MainActivity.this,listaPersonas,listView));
    }


}