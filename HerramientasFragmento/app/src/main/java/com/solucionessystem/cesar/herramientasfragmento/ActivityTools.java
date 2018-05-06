package com.solucionessystem.cesar.herramientasfragmento;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityTools extends AppCompatActivity implements ComunicaMenu{

    Fragment [] misFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        //recordar que en fragmento menu tenemos un array BOTONESMENU que tambien tiene tres item
        //entonces aqui tambien creamos los tres
        misFragmentos= new Fragment[3];
        misFragmentos[0]= new Linterna();
        misFragmentos[1]= new Musica();
        misFragmentos[2]= new Nivel();

        Bundle extras=getIntent().getExtras();
        menu(extras.getInt("BOTONPULSADO"));
    }

    @Override
    public void menu(int queBoton) {


        FragmentManager miManejador= getFragmentManager();

        FragmentTransaction miTransaccion=miManejador.beginTransaction();

        //----con esto haremos el iluminado del boton pulsado
        Fragment menu_iluminado= new Menu();
        Bundle datos= new Bundle();
        datos.putInt("BOTONPULSADO",queBoton);
        menu_iluminado.setArguments(datos);
        miTransaccion.replace(R.id.menu,menu_iluminado);
        //--------

        miTransaccion.replace(R.id.relative_herramientas,misFragmentos[queBoton]);

        miTransaccion.commit();

    }
}
