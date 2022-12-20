/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galeria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Kevin Magallanes
 */
public class Foto implements Serializable{
    private String titulo;
    private String fecha;
    private String lugar;
    private String nombreAlbum;
    private ArrayList<Persona> personasReconocidas;
    private String ruta;
    public Foto(String titulo,String fecha,String lugar, String nomAlbum,String ruta){
        this.titulo=titulo;
        this.fecha=fecha;
        this.lugar=lugar;
        this.nombreAlbum=nomAlbum;
        this.ruta=ruta;
        this.personasReconocidas=new ArrayList<>();
        
        
    }
    public Foto(String titulo,String fecha,String lugar,String nombreAlbum,String ruta,ArrayList<Persona> personasReconocidas){
       this(titulo, fecha, lugar, nombreAlbum, ruta);
        this.personasReconocidas=personasReconocidas;
       
        
    
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public ArrayList<Persona> getPersonasReconocidas() {
        return personasReconocidas;
    }

    public void setPersonasReconocidas(ArrayList<Persona> personasReconocidas) {
        this.personasReconocidas = personasReconocidas;
    }

    
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    @Override
     public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof Foto) {
            Foto otroFoto=(Foto) obj;
            return otroFoto.ruta.equals(this.ruta) ;
        }
        return false;
    }

    
     public void AñadirPersonas(Persona p){
      if (!(this.personasReconocidas.contains(p))){
          this.personasReconocidas.add(p);
      }
      else{
          System.out.println("La persona ya esta registrada");
      }
         
    }

    @Override
    public String toString() {
        return  "titulo=" + titulo + ", fecha=" + fecha + ", lugar=" + lugar + ", nombreAlbum=" + nombreAlbum + ", personasReconocidas=" + personasReconocidas + ", ruta=" + ruta;
    }
    
}
