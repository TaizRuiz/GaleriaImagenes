/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galeria;

/**
 *
 * @author Kevin Magallanes
 */
public class Usuario extends Persona {
    private String nomUsuario;
    private String contraseña;
    
    public Usuario(String nomUsuario, String contraseña, String nombre, String apellido){
        super(nombre, apellido);
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
    }
    public Usuario(String nombre,String apellido){
        super(nombre, apellido);
    }
    @Override
     public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof Usuario) {
            Usuario otroUsuario=(Usuario) obj;
            return (otroUsuario.nomUsuario.equals(this.nomUsuario)&& otroUsuario.contraseña.equals(this.contraseña)) ;
        }
        return false;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
