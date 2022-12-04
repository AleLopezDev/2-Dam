package com.example.proyectoandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class EventoBotones implements View.OnClickListener {

    Context context;

    public EventoBotones(MainActivity mainActivity) {
        this.context = mainActivity;
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        int id = b.getId();

        Log.d("id boton", String.valueOf(id));

        switch (id) {
            case 0:
                Intent i = new Intent(context, VistaClientes.class);
                context.startActivity(i);
                break;
            case 1:
                Intent i2 = new Intent(context, VistaEmpresa.class);
                context.startActivity(i2);
                break;
        }
    }
}
