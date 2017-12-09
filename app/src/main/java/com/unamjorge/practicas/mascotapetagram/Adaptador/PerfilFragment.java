package com.unamjorge.practicas.mascotapetagram.Adaptador;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unamjorge.practicas.mascotapetagram.Adaptadores.MascotaAdaptador;
import com.unamjorge.practicas.mascotapetagram.R;

import java.util.ArrayList;

import com.unamjorge.practicas.mascotapetagram.pojo.PojoMascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private ArrayList<PojoMascota> mascotaperfil;
    private RecyclerView listaMascotasperfil;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotasperfil = (RecyclerView)v.findViewById(R.id.rvPerfil);
        GridLayoutManager llm =new GridLayoutManager(getContext(),3);
        listaMascotasperfil.setLayoutManager(llm);
        InicializarListaMascotas();
        inicializarAdpatador();
        return v;
    }

    public void InicializarListaMascotas(){ //Método que inicializa la  lista
        mascotaperfil = new ArrayList<PojoMascota>();
        //llenado de la lista

        mascotaperfil.add(new PojoMascota(R.drawable.img1,"tobie"));
        mascotaperfil.add(new PojoMascota(R.drawable.img2,"Tobie"));
        mascotaperfil.add(new PojoMascota(R.drawable.img3,"TObie"));

    }

    public void inicializarAdpatador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotaperfil,getActivity());
        listaMascotasperfil.setAdapter(adaptador);
    }
}
