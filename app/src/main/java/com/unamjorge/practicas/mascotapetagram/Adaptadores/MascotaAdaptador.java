package com.unamjorge.practicas.mascotapetagram.Adaptadores;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.unamjorge.practicas.mascotapetagram.FavoritasMascota;
import com.unamjorge.practicas.mascotapetagram.R;
import com.unamjorge.practicas.mascotapetagram.pojo.PojoMascota;

import java.util.ArrayList;


/**
 * Created by Jorge Urueta on 21/11/2017.
 */



public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    //Método constructor
    public MascotaAdaptador(ArrayList <PojoMascota> pojoMascotas, Activity activity){
        this.pojoMascotas = pojoMascotas;
        this.activity = activity;


    }
    ArrayList<PojoMascota> pojoMascotas;
    Activity activity;
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }
    //Asocia cada elmento de la lista con cada View
    @Override
    public void onBindViewHolder(MascotaViewHolder MascotaViewHolder, int position) {
        final PojoMascota pojoMascota = pojoMascotas.get(position);
        MascotaViewHolder.imgMascota.setImageResource(pojoMascota.getFoto());
        MascotaViewHolder.tvNombre.setText(pojoMascota.getNombre());

        MascotaViewHolder.imgMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, pojoMascota.getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,FavoritasMascota.class);
                intent.putExtra("FOTO", pojoMascota.getFoto());
                intent.putExtra("NOMBRE", pojoMascota.getNombre());
                activity.startActivity(intent);
            }
        });


        MascotaViewHolder.bntLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste Like a "+ pojoMascota.getNombre(),Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() { //Cantidad de elemntos que contiene la lista
        return pojoMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvNombre;
        private ImageView bntLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota = (ImageView)itemView.findViewById(R.id.imgMascota);
            tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            bntLike = (ImageView)itemView.findViewById(R.id.huesoLike);

        }
    }
}
