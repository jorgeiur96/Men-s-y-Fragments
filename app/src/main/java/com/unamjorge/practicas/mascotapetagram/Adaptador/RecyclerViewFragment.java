package com.unamjorge.practicas.mascotapetagram.Adaptador;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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
public class RecyclerViewFragment extends Fragment {
    private ArrayList<PojoMascota> pojoMascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        InicializarListaMascotas();
        inicializarAdpatador();

        return v;
    }

    public void InicializarListaMascotas(){ //Método que inicializa la  lista
        pojoMascotas = new ArrayList<PojoMascota>();
        //llenado de la lista

        pojoMascotas.add(new PojoMascota(R.drawable.img1,"tobie"));
        pojoMascotas.add(new PojoMascota(R.drawable.img2,"Tobie"));
        pojoMascotas.add(new PojoMascota(R.drawable.img3,"Kira"));
        pojoMascotas.add(new PojoMascota(R.drawable.img4,"Luna"));
        pojoMascotas.add(new PojoMascota(R.drawable.img5,"Pit"));

    }

    public void inicializarAdpatador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(pojoMascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

}
