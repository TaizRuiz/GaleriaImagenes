/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galeria;
import java.util.ArrayList;


/**
 *
 * @author Kevin Magallanes
 */
public class Album {
    private String nombre;
    private String descripcion;
    private ArrayList<Foto> fotoContenidas;
    
    public Album(String nombre,String descripcion,ArrayList<Foto> fotoContenidas){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.fotoContenidas = new ArrayList<>();
    }
    
    public void añadirPersonas(){
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Foto> getFotoContenidas() {
        return fotoContenidas;
    }

    public void setFotoContenidas(ArrayList<Foto> fotoContenidas) {
        this.fotoContenidas = fotoContenidas;
    }
    
    public int compareTo(Album a){
    return this.nombre.compareTo(a.nombre);
  }
}
