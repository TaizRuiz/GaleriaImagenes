/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galeria;

/**
 *
 * @author Kevin Magallanes
 */
public class Galeria {
    private String nomUser;
    private String userPasswords;
    private ArrayList<Album> albumnesGaleria;
    
    public Galeria(String nomUser,String userPassword, ArrayList<Album> albumnesGaleria){
        this.nomUser=nomUser;
        this.userPasswords=userPassword;
        albumnesGaleria=new ArrayList<>();
    
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getUserPasswords() {
        return userPasswords;
    }

    public void setUserPasswords(String userPasswords) {
        this.userPasswords = userPasswords;
    }

    public ArrayList<Album> getAlbumnesGaleria() {
        return albumnesGaleria;
    }

    public void setAlbumnesGaleria(ArrayList<Album> albumnesGaleria) {
        this.albumnesGaleria = albumnesGaleria;
    }
    
    public void crearAlbum(Album a){
    }
    
    public void añadirFoto(Foto f){
    
    }
    
    public void mostraAlbumnes(){
    
    }
    
    public void moverFoto(Foto f, Album a){
        

    }
}
