/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galeria;

/**
 *
 * @author Kevin Magallanes
 */
public class Persona {
    protected String nombre;
    protected String apellido;
    
    
    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }
     @Override
     public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof Usuario) {
            Persona otraPersona=(Persona) obj;
            return (otraPersona.nombre.equals(this.nombre)&& otraPersona.apellido.equals(this.apellido)) ;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
        
}
