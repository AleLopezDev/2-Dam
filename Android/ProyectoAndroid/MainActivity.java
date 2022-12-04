package com.example.proyectoandroid;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyectoandroid.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private Button bCLientes, bEmpresas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bCLientes = findViewById(R.id.bClientes);
        bCLientes.setId(0);

        bEmpresas = findViewById(R.id.bEmpresas);
        bEmpresas.setId(1);


        addListeners();
    }

    public void addListeners() {
        bCLientes.setOnClickListener(new EventoBotones(MainActivity.this));
        bEmpresas.setOnClickListener(new EventoBotones(MainActivity.this));
    }

}