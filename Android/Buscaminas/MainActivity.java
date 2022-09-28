package com.example.buscaminas;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.buscaminas.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    ArrayList <View> btns = new ArrayList<>();
    boolean empezado = false;
    private TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addListeners();


    }

    public void addListeners(){
        RelativeLayout btnsBox = findViewById(R.id.relative);
        btns = btnsBox.getTouchables();

       /* for(View btn: btns) {
            ((Button) btn).setOnClickListener(this);
            ((Button) btn).setTag("");
        }*/

        for(int i =0;i<btns.size();i++){
            ((Button)btns.get(i)).setOnClickListener(this);
            ((Button)btns.get(i)).setTag(String.valueOf(i+1));
        }


    }

    public void onClick(View v){

        /*

          Con el numero aleatorio, cogemos el tag que ha salido.
          una vez que tenemos el boton con el setName le añadiremos la mina

         */


        Button btn = (Button) v;
        int numeroAleatorio = 0;
        tv = (TextView) findViewById(R.id.textView);

        if(!empezado){
            numeroAleatorio = (int) (Math.random()*btns.size()+1);
        }


       tv.setText(btn.getTag().toString());
       // empezado = true;

    }




}