package com.unamjorge.practicas.mascotapetagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.ArrayList;

import com.unamjorge.practicas.mascotapetagram.Adaptadores.MascotaAdaptador;
import com.unamjorge.practicas.mascotapetagram.pojo.PojoMascota;

public class FavoritasMascota extends AppCompatActivity {
    ImageView imgRaiting;
    ArrayList mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);
        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        imgRaiting=((ImageView)findViewById(R.id.sfiMirefres));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mascotas = new ArrayList<PojoMascota>();
        //llenado de la lista

        mascotas.add(new PojoMascota(R.drawable.img1,"Tobie"));
        mascotas.add(new PojoMascota(R.drawable.img2,"Luna"));
        mascotas.add(new PojoMascota(R.drawable.img3,"Kira"));
        mascotas.add(new PojoMascota(R.drawable.img4,"pit"));
        mascotas.add(new PojoMascota(R.drawable.img5,"Chanda"));


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvRanking);



        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        recyclerView.setAdapter(adaptador);


    }


}
