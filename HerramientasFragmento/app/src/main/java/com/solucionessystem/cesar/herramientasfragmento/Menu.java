package com.solucionessystem.cesar.herramientasfragmento;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {
    //identificacomos los id del fragmento fragment_menu.xml
    private final int [] BOTONESMENU={R.id.linterna,R.id.musica,R.id.nivel};

    private final int [] BOTONESMENUILUMINADOS={R.drawable.linterna2,R.drawable.musica2,R.drawable.nivel2};

    private  int boton;//variable que  almacenara el boton pulsado

    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View miMenu= inflater.inflate(R.layout.fragment_menu, container, false);

        //----con esto haremos el iluminado del boton pulsado
        boton=-1;//para
        if(getArguments()!=null){ //solo si se pasan arguemntos
            boton=getArguments().getInt("BOTONPULSADO");//rescatamos la informacion que se nos envia  en el bundle
        }


        Toast.makeText(getActivity(), "Boton pulsado:"+boton, Toast.LENGTH_SHORT).show();


        ImageButton botonMenu;

        ///recorremos todos los botones del xml
        for(int i=0;i<BOTONESMENU.length;i++){
            //almacenamos cada uno de los botones
            botonMenu=(ImageButton) miMenu.findViewById(BOTONESMENU[i]);

            //si el boton pulsado es igual al boton que se muestra lo ponemos ilumunado
            if(boton==i){
                botonMenu.setImageResource(BOTONESMENUILUMINADOS[i]);
            }

            final int queBoton =i;

            botonMenu.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v){
                    Activity estaActividad=getActivity();
                    //cateamos el menu
                    ((ComunicaMenu)estaActividad).menu(queBoton);

                }
            });
        }

        return miMenu;
    }

}
