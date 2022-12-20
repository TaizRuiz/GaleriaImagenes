/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galeria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
/**
 *
 * @author Kevin Magallanes
 */
public class Galeria implements Serializable{
    private Usuario owner;
    private ArrayList<Album> albumnesGaleria;
    public Galeria(Usuario o){
        this.owner=o;
        this.albumnesGaleria=new ArrayList<>();
        Collections.sort(this.albumnesGaleria);
    }
    public Galeria(Usuario o, ArrayList<Album> albumnesGaleria){
      this(o);
       this.albumnesGaleria=albumnesGaleria;
        Collections.sort(albumnesGaleria);
    
    }
    @Override
     public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof Galeria) {
            Galeria otroGaleria=(Galeria) obj;
            return (otroGaleria.getOwner().equals(this.owner)) ;
        }
        return false;
    }

    public Usuario getOwner() {
        return owner;
    }

    public void setOwner(Usuario owner) {
        this.owner = owner;
    }

  

    public ArrayList<Album> getAlbumnesGaleria() {
        return albumnesGaleria;
    }


    public void setAlbumnesGaleria(ArrayList<Album> albumnesGaleria) {
        this.albumnesGaleria = albumnesGaleria;
    }
    
    public void crearAlbum(Album a){
     if (!(this.albumnesGaleria.contains(a))){
         this.albumnesGaleria.add(a);
     }  
     else{
         System.out.println("el album ya existe");
     }
    }
    
    
    public void añadirFoto(Foto f, Album a){
        if (this.albumnesGaleria.contains(a)){
            if (!(a.getFotoContenidas().contains(f))){
                a.getFotoContenidas().add(f);
            }
            else{
                System.out.println("La foto ya existe en el album seleccionado");
            }
        }
        else{
            System.out.println("El album ingresado no existe");
        }
    }
    
    public void mostraAlbumnes(){
        for (Album ab: this.albumnesGaleria){
            System.out.println(ab);
        }
    }
    
    public void moverFoto(Foto f, Album aSalida,Album aLLegada ){
        if (this.albumnesGaleria.contains(aSalida)&& this.albumnesGaleria.contains(aLLegada)){
            if (aSalida.getFotoContenidas().contains(f)){
                int indice=aSalida.getFotoContenidas().indexOf(f);
                Foto datosFoto=aSalida.getFotoContenidas().get(indice);
                Foto nuevaFoto=new Foto(datosFoto.getTitulo(), datosFoto.getFecha(), datosFoto.getLugar(), aLLegada.getNombre(), datosFoto.getRuta());
                if (!(aLLegada.getFotoContenidas().contains(nuevaFoto))){
                    aLLegada.getFotoContenidas().add(nuevaFoto);
                     aSalida.getFotoContenidas().remove(indice);
                }
            }
           
        }

    }
}
