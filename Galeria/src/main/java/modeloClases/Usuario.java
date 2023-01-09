/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloClases;

import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class Usuario  implements Serializable{
    String nomUser;
    String passW;
    String nombre;

    public Usuario(String nomUser, String passW) {
        this.nomUser = nomUser;
        this.passW = passW;
        
    }
    public Usuario(String nomUser, String passW,String nom) {
       this(nomUser, passW);
        this.nombre=nom;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPassW() {
        return passW;
    }

    public void setPassW(String passW) {
        this.passW = passW;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     @Override
     public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof Usuario) {
            Usuario otraPersona=(Usuario) obj;
            return (this.nomUser.equals(otraPersona.nomUser)&& this.passW.equals(otraPersona.passW)) ;
        }
        return false;
    }

}