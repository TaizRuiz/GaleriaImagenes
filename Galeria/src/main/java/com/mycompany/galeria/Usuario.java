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
}
