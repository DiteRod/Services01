package com.example.perso.services01;

import java.util.ArrayList;

public class Post {
    private String titulo;
    private String descripcion;
    private ArrayList<String> taqs;

    public Post(String titulo, String descripcion, ArrayList<String> taqs) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.taqs = taqs;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<String> getTaqs() {
        return taqs;
    }

    public void setTaqs(ArrayList<String> taqs) {
        this.taqs = taqs;
    }
}

