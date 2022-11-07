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
        listView = (ListView)findViewById(R.id.listView);

        createPeople = (Button) findViewById(R.id.botonPersona);
        populateListViewButton = (Button) findViewById(R.id.botonListView);


        createPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearPersonas();
            }
        });

        populateListViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rellenarListView();
            }
        });


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

    public void rellenarListView(){

        // Mi clase customAdapter
        CustomAdapter myCustomAdapter = new CustomAdapter(MainActivity.this,listaPersonas);
        listView.setAdapter(myCustomAdapter);
    }
}