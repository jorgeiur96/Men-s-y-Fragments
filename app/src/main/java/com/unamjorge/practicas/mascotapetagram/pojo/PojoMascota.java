package com.unamjorge.practicas.mascotapetagram.pojo;

/**
 * Created by Jorge Urueta on 28/11/2017.
 */

public class PojoMascota {

    private int foto;
    private String nombre;

    public PojoMascota(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
