/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloClases;

import java.io.Serializable;

/**
 *
 * @author Kevin Magallanes
 */
public class Persona implements Serializable {
    protected String nombre;
    
    
    
    public Persona(String nombre){
        this.nombre = nombre;
        
    }
     @Override
     public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof Persona) {
            Persona otraPersona=(Persona) obj;
            return (otraPersona.nombre.equals(this.nombre)) ;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
        
}
