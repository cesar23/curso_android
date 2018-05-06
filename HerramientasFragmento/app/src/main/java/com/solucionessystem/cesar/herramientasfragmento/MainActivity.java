package com.solucionessystem.cesar.herramientasfragmento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ComunicaMenu{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void menu(int queBoton) {
        Intent in= new Intent(this,ActivityTools.class);
        in.putExtra("BOTONPULDADO",queBoton);
        startActivity(in);
    }
}
