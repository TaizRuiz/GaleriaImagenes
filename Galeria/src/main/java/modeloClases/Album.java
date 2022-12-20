/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galeria;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author Kevin Magallanes
 */
public class Album implements Serializable, Comparable<Album>{
    private String nombre;
    private String descripcion;
    private ArrayList<Foto> fotoContenidas;
    public Album(String nombre,String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
    public Album(String nombre,String descripcion,ArrayList<Foto> fotoContenidas){
        this(nombre, descripcion);
        this.fotoContenidas = fotoContenidas;
    }
    
    @Override
     public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof Album) {
            Album otroAlbum=(Album) obj;
            return (otroAlbum.nombre.equals(this.nombre)&& otroAlbum.descripcion.equals(this.descripcion)) ;
        }
        return false;
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
    @Override
    public int compareTo(Album a){
    return this.nombre.compareTo(a.nombre);
  }
  public void mostrarContenido(){
      for (Foto f: this.fotoContenidas){
          System.out.println(f);
      }
  }

    @Override
    public String toString() {
        return  "nombre=" + nombre + ", descripcion=" + descripcion + ", fotoContenidas=" + fotoContenidas ;
    }
  
}
