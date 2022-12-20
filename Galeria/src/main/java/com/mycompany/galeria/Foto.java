/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galeria;

/**
 *
 * @author Kevin Magallanes
 */
public class Foto {
    private String titulo;
    private String fecha;
    private String lugar;
    private String nombreAlbum;
    private ArrayList<String> personasReconocidas;
    private String ruta;
    
    public Foto(String titulo,String fecha,String lugar,String nombreAlbum,ArrayList<String> personasReconocidas,String ruta){
        this.titulo=titulo;
        this.fecha=fecha;
        this.lugar=lugar;
        this.nombreAlbum=nombreAlbum;
        this.personasReconocidas=personasReconocidas;
        this.ruta=ruta;
    
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

    public ArrayList<String> getPersonasReconocidas() {
        return personasReconocidas;
    }

    public void setPersonasReconocidas(ArrayList<String> personasReconocidas) {
        this.personasReconocidas = personasReconocidas;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
     public void AñadirPersonas(){
       
    }
}
